package com.my.longtail.restcontroller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.my.longtail.model.ApplicantFormPOJO;
import com.my.longtail.model.EntityType;
import com.my.longtail.model.Franchise;
import com.my.longtail.model.FranchiseType;
import com.my.longtail.model.MaritalStatus;
import com.my.longtail.model.Money;
import com.my.longtail.model.SourceFundType;
import com.my.longtail.property.Property;

@RestController
public class InvestorRestController {

	@Autowired
	InvestorService investorService;
	
	final static String foldername = Property.getWEBPORTAL_FOLDER_NAME();
	
//	@RequestMapping(value = "/investcontroller/get_franchise_list", method = RequestMethod.GET)
//	private List<Franchise> getFranchiseListing() {
//		return null;
//	}
	
	@RequestMapping(value = "/investorcontroller/top_recommended_franchise_list", method = RequestMethod.GET)
	private List<Franchise> getTopRecommendedFranchiseListing() {
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		List<Franchise> franchiseList = investorService.getTop5RecommendedFranchiseNByFranchiseType(username);
		if(franchiseList.isEmpty())
			throw new IllegalArgumentException("getTopRecommendedFranchiseListing EMPTY");
		return franchiseList;
	}
	
	@RequestMapping(value = "/investorcontroller/top_latest_franchise_list", method = RequestMethod.GET)
	private List<Franchise> getTopLatestFranchiseListing() {

		List<Franchise> franchiseList = investorService.getRop5LatestFranchise();
		if(franchiseList.isEmpty())
			throw new IllegalArgumentException("getTopLatestFranchiseListing EMPTY");
		return franchiseList;
	}
	
	@RequestMapping(value = "/investorcontroller/top_popular_franchise_list", method = RequestMethod.GET)
	private List<Franchise> getTopPopularFranchiseListing() {
		List<Franchise> franchiseList = investorService.getTop5PopularFranchise();
		if(franchiseList.isEmpty())
			throw new IllegalArgumentException("getTopLatestFranchiseListing EMPTY");
		return franchiseList;
	}
	
	@RequestMapping(value = "/investorcontroller/recommended_franchise_list", method = RequestMethod.GET)
	private List<Franchise> getRecommededFranchiseListing(@PageableDefault(value = 10)Pageable pageable){
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		Page<Franchise> pages = investorService.getAllRecommendedFranchiseType(username, pageable);
		if(pages.isEmpty())
			throw new IllegalArgumentException("getRecommededFranchiseListing EMPTY");
		return pages.getContent();
	}
	
	@RequestMapping(value = "/investorcontroller/latest_franchise_list", method = RequestMethod.GET)
	private List<Franchise> getPopularFranchiseListing(@PageableDefault(value = 10)Pageable pageable){
		Page<Franchise> pages = investorService.getAllPopularFranchise(pageable);
		if(pages.isEmpty())
			throw new IllegalArgumentException("getPopularFranchiseListing EMPTY");
		return pages.getContent();
	}
	
	@RequestMapping(value = "/investorcontroller/popular_franchise_list", method = RequestMethod.GET)
	private List<Franchise> getLatestFranchiseListing(@PageableDefault(value = 10)Pageable pageable){
		Page<Franchise> pages = investorService.getAllLatestFranchise(pageable);
		if(pages.isEmpty())
			throw new IllegalArgumentException("getLatestFranchiseListing EMPTY");
		return pages.getContent();
	}
	
	@RequestMapping(value = "/investorcontroller/save_applicant", method = RequestMethod.POST)
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
	}
	
	//change
	@RequestMapping(value = "/investorcontroller/set_interested/{id}", method = RequestMethod.POST)
	private String setInterestedFranchise(@PathVariable long franchiseId, HttpServletRequest request, HttpServletResponse response) {
		JSONObject jObjectResult = new JSONObject();
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			Franchise franchise = investorService.setInterestedFranchise(franchiseId, username);
			if(franchise == null) {
				Logger.writeActivity("empty franchise interested", foldername);
				jObjectResult.put("data", "Please try again later.");
				return jObjectResult.toString();
			}
			jObjectResult.put("data", franchise.getId());
		}catch(Exception e){
			e.printStackTrace();
			Logger.writeError(e, "Exception: ", foldername);
			return null;
		}
		return jObjectResult.toString();
	}
	
	//change
	@RequestMapping(value = "/investorcontroller/set_uninterested/{id}", method = RequestMethod.POST)
	private String setUninterestedFranchise(@PathVariable long franchiseId) {
		JSONObject jObjectResult = new JSONObject();
		try {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			Franchise franchise = investorService.setUninterestFranchise(franchiseId, username);
			if(franchise == null) {
				Logger.writeActivity("empty franchise uninterested", foldername);
				jObjectResult.put("data", "Please try again later.");
				return jObjectResult.toString();
			}
			jObjectResult.put("data", franchise.getId());
		}catch(Exception e) {
			e.printStackTrace();
			Logger.writeError(e, "Exception: ", foldername);
			return null;
		}
		return jObjectResult.toString();
	}
	
}
