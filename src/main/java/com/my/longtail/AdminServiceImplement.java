package com.my.longtail;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Currency;
import java.util.Date;
import java.util.List;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.my.longtail.logger.Logger;
import com.my.longtail.model.Category;
import com.my.longtail.model.Country;
import com.my.longtail.model.Franchise;
import com.my.longtail.model.Money;
import com.my.longtail.model.OfferorForm;
import com.my.longtail.property.Property;
import com.my.longtail.repositories.CategoryRepository;
import com.my.longtail.repositories.CountryRepository;
import com.my.longtail.repositories.FranchiseRepository;
import com.my.longtail.repositories.OfferorFormRepository;
import com.my.longtail.util.UserUtil;

@Service("adminServiceImplement")
public class AdminServiceImplement implements AdminService{
	
	@Value("${upload-path}")
	private String filePath;
	
	@Autowired
	FranchiseRepository franchiseRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	CountryRepository countryRepository;
	
	@Autowired
	OfferorFormRepository offerorFormRepository;
	
	final static String foldername = Property.getWEBPORTAL_FOLDER_NAME();
	
	@Override
	public Franchise saveFranchise(Franchise franchise) {
		return franchiseRepository.save(franchise);
	}

	@Override
	public Franchise updateFranchise(Franchise franchise) {
		Franchise existing = franchiseRepository.getOne(franchise.getId());
		
		if(existing == null)
			return null;
		
		franchise.merge(existing);
		return franchiseRepository.save(existing);
	}

	@Override
	public boolean removeFranchise(long franchiseId) {
		Franchise franchise = franchiseRepository.getOne(franchiseId);
		if(franchise == null)
			return false;
		try {
			franchiseRepository.delete(franchise);
		}catch(Exception e) {
			e.printStackTrace();
			Logger.writeError(e, "Exception: ", foldername);
			return false;
		}
		return true;
	}

	@Override
	public List<Franchise> getAllFranchise() {
		return franchiseRepository.findAllByOrderByDateCreatedAsc();
//		return null;
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategory(long categoryId) {
		return categoryRepository.getOne(categoryId);
	}

	@Override
	public OfferorForm saveOfferor(String formfield) {
		OfferorForm offeror = new OfferorForm();
		OfferorForm savedOfferor = null;
		
		try {
			JSONObject formfield_main = new JSONObject(formfield);
			JSONObject jObject = formfield_main.getJSONObject("formfield");
			
			offeror.setAddress(jObject.getString("address"));
			offeror.setCategory(categoryRepository.getOne(Long.valueOf(jObject.getString("category_id"))));
			offeror.setCompanyNumber(jObject.getString("company_number"));
			offeror.setCorporateDocument(saveImageFile(jObject.getString("corporateDocImg64"), null));
			
			Country country = countryRepository.getOne(Long.valueOf(jObject.getString("country_id")));
			if(country != null)
				offeror.setCountry(country);
			else
				return null;
			
			Country countryInc = countryRepository.getOne(Long.valueOf(jObject.getString("country_incorporation")));
			if(countryInc != null)
				offeror.setCountryIncorporation(countryInc);
			else
				return null;
			
			String dateInc = jObject.getString("country_incorporation").replaceAll("T", " ").replaceAll("Z", "");
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			Date date_Inc = dt.parse(dateInc);
			offeror.setDateIncorporation(date_Inc);
			offeror.setDateSubmitted(new Date());
			offeror.setDisclosureDocument(saveImageFile(jObject.getString("disclosureDocImg64"), null));
			offeror.setOfferorName(jObject.getString("name"));
			offeror.setPrincipalContactPersonName(jObject.getString("principalContactName"));
			offeror.setPrincipalContactPersonNumber(jObject.getString("principalContactNumber"));
			offeror.setTelephoneNumber(jObject.getString("telephone_number"));
			Money fullAmountOffering = new Money(new BigDecimal(jObject.getString("offerAmount")), Currency.getInstance(jObject.getString("offerCurrency")));
			offeror.setFullAmountOffering(fullAmountOffering);
			
			savedOfferor = offerorFormRepository.save(offeror);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return savedOfferor;
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
}
