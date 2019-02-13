package com.my.longtail.restcontroller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Currency;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.my.longtail.InvestorService;
import com.my.longtail.logger.Logger;
import com.my.longtail.model.AccountType;
import com.my.longtail.model.ApplicantFormPOJO;
import com.my.longtail.model.Category;
import com.my.longtail.model.Country;
import com.my.longtail.model.EntityType;
import com.my.longtail.model.Franchise;
import com.my.longtail.model.FranchiseType;
import com.my.longtail.model.MaritalStatus;
import com.my.longtail.model.Money;
import com.my.longtail.model.SourceFundType;
import com.my.longtail.model.Transaction;
import com.my.longtail.model.Users;
import com.my.longtail.property.Property;
import com.my.longtail.repositories.CategoryRepository;
import com.my.longtail.repositories.CountryRepository;
import com.my.longtail.util.UserUtil;

@RestController
@RequestMapping(value = "/investcontroller")
public class InvestorRestController {

	@Autowired
	InvestorService investorService;
	
	@Autowired
	CountryRepository countryRepository;
	
	@Value("${upload-path}")
	private String filePath;
	
	final static String foldername = Property.getWEBPORTAL_FOLDER_NAME();	
	
	@RequestMapping(value = "/save_applicant", method = RequestMethod.POST)
	private String saveApplicantFormData(@RequestBody String formfield, HttpServletRequest request, HttpServletResponse response) {
		JSONObject jObjectResult = new JSONObject();
		ApplicantFormPOJO formdata = new ApplicantFormPOJO();
		Transaction transaction = new Transaction();
		ApplicantFormPOJO savedFormData = null;
		
		int indicator = 0;
		
		try {
			JSONObject formfield_main = new JSONObject(formfield);
			JSONObject jObject = formfield_main.getJSONObject("formfield");
			
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			
			indicator = jObject.getInt("action_indicator");

			formdata.setAddress(jObject.getString("address"));
			formdata.setBankDetails(jObject.getString("bank_details"));
			
			JSONArray array_category = jObject.getJSONArray("category");
			Set<Category> categorySet = new HashSet<Category>();
			for(int i=0; i < array_category.length(); i++) {
				String id = array_category.getString(i);
				categorySet.add(investorService.getCategory(Long.parseLong(id)));
			}
			formdata.setCategoriesParticpate(categorySet);
			Country country = investorService.getCountry(Long.parseLong(jObject.getString("country_id")));
			formdata.setCountryChoice(country);
			formdata.setGender(jObject.getString("gender"));
			formdata.setImgPassport(saveImageFile(indicator, jObject.getString("passport64"), 
					jObject.has("existing_passport") == true ? jObject.getString("existing_passport") : null));
			formdata.setImgProfilePhoto(saveImageFile(indicator, jObject.getString("profile64"), 
					jObject.has("existing_profile") == true ? jObject.getString("existing_profile") : null));
			formdata.setImgProofAddress(saveImageFile(indicator, jObject.getString("address64"), 
					jObject.has("existing_address") == true ? jObject.getString("existing_address") : null));
			Money investmentRange = new Money();
			investmentRange.setAmount(new BigDecimal(jObject.getString("invest_range")));
			formdata.setInvestmentRange(investmentRange);
			formdata.setManagementParticipation(jObject.getBoolean("management_participate"));
			formdata.setNationality(jObject.getString("nationality"));
			formdata.setParticipantName(jObject.getString("participant_name"));
			formdata.setPassportNumber(jObject.getString("passport_number"));
			formdata.setPercentageShareTarget(new BigDecimal(jObject.getString("percentage_share_target")));
			formdata.setSeekOutPeriod(Integer.parseInt(jObject.getString("seekout_period")));
			formdata.setTelephoneNumber(jObject.getString("telephone_number"));
			
			if(indicator == 1) {
				formdata.setDateSubmitted(new Date());
				savedFormData = investorService.saveApplicantForm(formdata, username);
			}else if(indicator == 2) {
				formdata.setDateUpdated(new Date());
				savedFormData = investorService.updateApplicantForm(formdata, username, Long.parseLong(jObject.getString("id")));
			}
			
			if(savedFormData == null)
				throw new IllegalArgumentException("Fail to save applicant form.");
			
//			formdata.setTransaction(transaction);
			
//			transaction.setApplicantForm(savedFormData);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private String saveImageFile(int indicator, String base64_img, String existingPath) {
		boolean checker = false;
		String imageName = null;
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String uploadPath = filePath;
		String folderName = null;
		String[] splitString = base64_img.split(",");
		byte[] imageBytes = Base64.getDecoder().decode(splitString[1]);
		
		try {
			File checkdir = new File(uploadPath);
			checkdir.mkdirs();
		
			//gen folder name
			if(existingPath == null || existingPath.equals("")) {
				
			}
			
			switch(indicator) {
			case 1:
				imageName = "passport_photo"+sdf.format(date).toString();
			case 2:
				imageName = "profile_photo"+sdf.format(date).toString();
			case 3:
				imageName = "address_proof"+sdf.format(date).toString();

			
			do {
				File checkFile = new File(uploadPath + imageName);
				if(checkFile.exists()) {
					checker = true;
					//what if name exist
				}else
					checker = false;
			}while(checker);
		
			File file = new File(uploadPath, imageName+".png");
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(imageBytes);
			fos.close();
		}

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	private String registerInvestor(@RequestBody String formfield, HttpServletRequest request, HttpServletResponse response) {
		Users newUser = new Users();
		
		try {
			JSONObject formfield_main = new JSONObject(formfield);
			JSONObject jObject = formfield_main.getJSONObject("formfield");
			
			newUser.setAccountType(AccountType.INVESTOR);
			Country country = countryRepository.getOne(Long.valueOf(jObject.getString("country")));
			newUser.setCountry(country);
			newUser.setEmail(jObject.getString("email"));
			newUser.setFirstName(jObject.getString("first_name"));
			newUser.setLastName(jObject.getString("last_name"));
			newUser.setPassword(jObject.getString("password"));
			newUser.setProfile_image(saveImageFile(jObject.getString("profile_img"), null));
			newUser.setProvider(jObject.getString("provider"));
			newUser.setUsername(jObject.getString("username"));
			
			newUser = investorService.registerUser(newUser);
			if(newUser == null)
				return "Registration Failed. Please Try Again Later.";
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@RequestMapping(value = "/get_country_list", method = RequestMethod.GET)
	public String getCountryList(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("getting country list");
		JSONObject jObjectResult = new JSONObject();
		JSONArray JARY = new JSONArray();
		JSONObject content = null;
		try {
			List<Country> countries = countryRepository.findAll();
			
			for(Country country : countries) {
				content = new JSONObject();
				content.put("id", country.getId());
				content.put("name", country.getName());
				content.put("currency_code", country.getCurrency());
				JARY.put(content);
			}
			jObjectResult.put("data", JARY);
		}catch(Exception e) {
			//logger here
			e.printStackTrace();
		}
		System.out.println("result "+ jObjectResult.toString());
		return jObjectResult.toString();
	}
	
	private String saveImageFile(String base64_img, String existing) {
		boolean checker = false;
		String imageName = UserUtil.randomString(8);
		String uploadPath = filePath;
		String[] splitString = base64_img.split(",");
		byte[] imageBytes = Base64.getDecoder().decode(splitString[1]);

		try {
			File checkdir = new File(uploadPath);
			checkdir.mkdirs();
			
			if (existing != null) {
				File tempfile = new File(uploadPath + existing);
				tempfile.delete();
			}
	
			do {
				File checkFile = new File(uploadPath + imageName);
				if (checkFile.exists()) {
					checker = true;
					imageName = UserUtil.randomString(8);
				} else {
					checker = false;
				}
			} while (checker);

			File file = new File(uploadPath, imageName + ".png");
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(imageBytes);
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imageName + ".png";
	}
	
	
	/*@RequestMapping(value = "/investorcontroller/save_applicant", method = RequestMethod.POST)
	private String saveApplicantFranchiseData(@RequestBody String formfield, HttpServletRequest request, HttpServletResponse response) {
		JSONObject jObjectResult = new JSONObject();
		ApplicantFormPOJO formData = new ApplicantFormPOJO();
		int indicator = 0;
		
		try {
			JSONObject formfield_main = new JSONObject(formfield);
			JSONObject jObject = formfield_main.getJSONObject("formfield");
			
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			
			indicator = jObject.getInt("action_indicator");
			if(indicator == 1)
				formData.setCreatedDate(new Date());
			else
				formData.setUpdatedDate(new Date());
			
			formData.setAcademicQualification(jObject.getString("academic_qualification"));
			formData.setApplicantStrength(jObject.getString("applicant_strength"));
			formData.setBusinessDescription(jObject.getString("business_description"));
			formData.setBusinessLocation(jObject.getString("business_location"));
			formData.setBusinessNature(jObject.getString("business_nature"));
			formData.setBusinessPeriod(jObject.getInt("business_period"));
			Money capitalisation = new Money(new BigDecimal(jObject.getString("capitalisation_amount")), Currency.getInstance(jObject.getString("capitalisation_currency")));
			formData.setCapitalisation(capitalisation);
			formData.setCompanyBusinessName(jObject.getString("company_business_name"));
			formData.setCorpEmail(jObject.getString("corp_email"));
			formData.setCorpFax(jObject.getString("corp_fax"));
			formData.setCorpPhoneNo(jObject.getString("corp_phone_no"));
			formData.setCountryOrigin(jObject.getString("country_origin"));
			formData.setCountryTerritory(jObject.getString("country_territory"));
			formData.setEmail(jObject.getString("email"));
			formData.setEmployerBusinessName(jObject.getString("employer_business_name"));
			formData.setEntityType(EntityType.fromValue(jObject.getInt("entity_type")));
			formData.setFax(jObject.getString("fax"));
			formData.setFranchiseFamiliarity(jObject.getInt("franchise_familiarity"));
			formData.setFranchiseName(jObject.getString("franchise_name"));
			formData.setFranchisePeriod(jObject.getString("franchise_period"));
			formData.setFranchiseReason(jObject.getString("franchise_reason"));
			Money fundsAvailableInvest = new Money(new BigDecimal(jObject.getString("source_fund_amount")), Currency.getInstance(jObject.getString("source_fund_currency")));
			formData.setFundAvailableInvest(fundsAvailableInvest);
			formData.setOfficePhoneNo(jObject.getString("office_phone"));
			formData.setIncorporationNumber(jObject.getString("incorporation_number"));
			formData.setIncorporationRegistration(jObject.getString("incorporation_registration"));
			formData.setInterestedFranchise(FranchiseType.fromValue(jObject.getInt("franchise_interested")));
			formData.setManagingPrincipal(jObject.getString("managing_principal"));
			formData.setMaritalStatus(MaritalStatus.fromValue(jObject.getInt("marital_status")));
			formData.setMobilePhoneNo(jObject.getString("mobile_phone"));
			Money monthlyRent = new Money(new BigDecimal("monthly_rent_amount"), Currency.getInstance(jObject.getString("monthly_rent_currency")));
			formData.setMonthlyRent(monthlyRent);
			formData.setmPrincipalAge(jObject.getInt("mPrincipal_age"));
			formData.setmPrincipalMaritalStatus(MaritalStatus.fromValue(jObject.getInt("mPrincipal_marital_status")));
			formData.setmPrincipalNationality(jObject.getString("mPrincipal_nationality"));
			formData.setmPrincipalOccupationDesignation(jObject.getString("mPrincipal_occupation_designation"));
			formData.setName(jObject.getString("name"));
			formData.setNationality(jObject.getString("nationality"));
			formData.setOccupationBusiness(jObject.getString("occupation_business"));
			formData.setOperatedFranchise(jObject.getBoolean("operated_franchise"));
			formData.setOperateKindergarden(jObject.getBoolean("operated_kindergarden"));
			formData.setOperationEducationTraining(jObject.getInt("operation_education_training"));
			formData.setOtherEntity(jObject.getString("other_entity"));
			formData.setPercentageShare(jObject.getString("percentage_share"));
			formData.setPremiseLocation(jObject.getString("premise_location"));
			formData.setPremiseOwn(jObject.getBoolean("premise_own"));
			Money preYearSalesTurnOver = new Money(new BigDecimal(jObject.getString("preYearSales_amount")), Currency.getInstance(jObject.getString("preYearSales_currency")));
			formData.setPreYearSalesTurnOver(preYearSalesTurnOver);
			formData.setPreYearSalesTurnOverParam1(jObject.getString("param1"));
			formData.setPreYearSalesTurnOverParam2(jObject.getString("param2"));
			formData.setRelevantInfo(jObject.getString("relevant_info"));
			formData.setResidentCountryAddress(jObject.getString("resident_country_address"));
			formData.setCorpResidentAddress(jObject.getString("c_resident_address"));
			formData.setSourceFunds(SourceFundType.fromValue(jObject.getInt("source_fund")));
			formData.setYearBirth(jObject.getString("year_birth"));
			formData.setYearIncorporated(jObject.getInt("year_incorporated"));
			formData.setApplicantPosition(jObject.getString("applicant_position"));
			
			String stringFormDate = jObject.getString("form_date").replaceAll("T", " ").replaceAll("Z", "");
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			Date formDate = dt.parse(stringFormDate);
			formData.setFormDate(formDate);
			
			if(indicator == 1) {
				formData = investorService.saveApplicantForm(formData, username);
				if(formData == null) {
					Logger.writeActivity("could not save form data", foldername);
					jObjectResult.put("data", "Failed to save form. Please Try Again Later.");
				}
			}
			else {
				formData = investorService.updateApplicantForm(formData, username);
				if(formData == null) {
					Logger.writeActivity("fail to update form data", foldername);
					jObjectResult.put("data", "Failed to save changes. Please Try Again Later.");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
			Logger.writeError(e, "Exception: ", foldername);
		}
		
		return jObjectResult.toString();
	}*/
	
}
