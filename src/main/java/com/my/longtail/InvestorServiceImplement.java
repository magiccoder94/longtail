package com.my.longtail;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Currency;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.longtail.logger.Logger;
import com.my.longtail.model.ApplicantFormPOJO;
import com.my.longtail.model.Category;
import com.my.longtail.model.Country;
import com.my.longtail.model.Franchise;
import com.my.longtail.model.Money;
import com.my.longtail.model.Transaction;
import com.my.longtail.model.TransactionStatus;
import com.my.longtail.model.TransactionType;
import com.my.longtail.model.Users;
import com.my.longtail.model.Users_ApplicantForms;
import com.my.longtail.property.Property;
import com.my.longtail.repositories.ApplicantFormRepository;
import com.my.longtail.repositories.CategoryRepository;
import com.my.longtail.repositories.CountryRepository;
import com.my.longtail.repositories.FranchiseRepository;
import com.my.longtail.repositories.UserApplicantFormRepository;
import com.my.longtail.repositories.UsersRepository;

@Service("investorServiceImplement")
public class InvestorServiceImplement implements InvestorService{

	@Autowired
	UsersRepository userRepository;
	
	@Autowired
	FranchiseRepository franchiseRepository;
	
	@Autowired
	ApplicantFormRepository applicantFormRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	CountryRepository countryRepository;

	@Autowired
	UserApplicantFormRepository userApplicantFormRepository;
	
	final static String foldername = Property.getWEBPORTAL_FOLDER_NAME();

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ApplicantFormPOJO saveApplicantForm(ApplicantFormPOJO formdata, String username) {
		Users_ApplicantForms userApplicantForm = new Users_ApplicantForms();
		//check that the user did not recently submited form?
		Users user = userRepository.findByUsername(username);
		if(user == null) {
			//create the user?
			Logger.writeActivity("User is not yet created", foldername);
			throw new IllegalArgumentException("User is not yet created");
		}
		ApplicantFormPOJO savedForm = applicantFormRepository.save(formdata);
		if(savedForm == null) {
			Logger.writeActivity("Fail to save applicant form.", foldername);
			throw new IllegalArgumentException("Fail to save applicant form.");
		}
		
		userApplicantForm.setUser(user);
		userApplicantForm.setApplicantForm(savedForm);
		
		if(userApplicantFormRepository.save(userApplicantForm) == null) {
			Logger.writeActivity("Fail to map user to applicant form", foldername);
			throw new IllegalArgumentException("Fail to map user to applicant form");
		}
		
		return savedForm;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ApplicantFormPOJO updateApplicantForm(ApplicantFormPOJO formdata, String username, Long formId) {
		Users user = userRepository.findByUsername(username);
		
		if(user == null) {
			Logger.writeActivity("fail to find user", foldername);
			return null;
		}
		
		ApplicantFormPOJO existing = applicantFormRepository.getOne(formId);
		if(existing == null) {
			Logger.writeActivity("fail to find applicant form data", foldername);
			return null;
		}
		
		formdata.merge(existing);
		
		return applicantFormRepository.save(existing);
	}

	@Override
	public Country getCountry(long id) {
		return countryRepository.getOne(id);
	}

	@Override
	public Category getCategory(long id) {
		return categoryRepository.getOne(id);
	}

	@Override
	public Transaction peformTransaction(String username, ApplicantFormPOJO savedFormData) {
		Transaction transaction = new Transaction();
		Users user = userRepository.findByUsername(username);
		if(user == null) {
			Logger.writeActivity("fail to find user", foldername);
			return null;
		}
		
		transaction.setTransactionType(TransactionType.DEPOSIT);
		transaction.setTransactionStatus(TransactionStatus.PENDING);
		
		//fix deposit for now*
		Money deposit = new Money(new BigDecimal("200"), Currency.getInstance("MYR"));
		transaction.setTransactionAmount(deposit);
//		transaction.setMessage();
		return null;
	}

	@Override
	public Users registerUser(Users user) {
		return userRepository.save(user);
	}

	@Override
	public Users checkRegisteredEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public Users getUser(String username) {
		return userRepository.findByUsername(username);
	}

	
	
}
