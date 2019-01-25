package com.my.longtail;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Base64;
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
import com.my.longtail.property.Property;
import com.my.longtail.repositories.ApplicantFormRepository;
import com.my.longtail.repositories.CategoryRepository;
import com.my.longtail.repositories.CountryRepository;
import com.my.longtail.repositories.FranchiseRepository;
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
	
	final static String foldername = Property.getWEBPORTAL_FOLDER_NAME();

	@Transactional(rollbackFor = Exception.class)
	@Override
	public ApplicantFormPOJO saveApplicantForm(ApplicantFormPOJO formdata, String username) {
		return applicantFormRepository.save(formdata);
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
		return null;
	}

	
	
}
