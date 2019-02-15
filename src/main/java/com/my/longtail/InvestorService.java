package com.my.longtail;

import java.util.List;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.my.longtail.model.ApplicantFormPOJO;
import com.my.longtail.model.Category;
import com.my.longtail.model.Country;
import com.my.longtail.model.Franchise;
import com.my.longtail.model.Transaction;
import com.my.longtail.model.Users;

public interface InvestorService {
//	Franchise setInterestedFranchise(long franchiseId, String username);
//	Franchise setUninterestFranchise(long franchiseId, String username);
//	Page<Franchise> getFranchiseList(Pageable pageable);
//	Page<Franchise> getAllPopularFranchise(Pageable pageable);
//	Page<Franchise> getAllRecommendedFranchiseType(String username, Pageable pageable);
//	Page<Franchise> getAllFranchiseByCategory(long categoryId, Pageable pageable);
//	Page<Franchise> getAllLatestFranchise(Pageable pageable);
//	List<Franchise> getTop5PopularFranchise();
//	List<Franchise> getTop5RecommendedFranchiseNByFranchiseType(String username);
//	List<Franchise> getRop5LatestFranchise();
	ApplicantFormPOJO saveApplicantForm(ApplicantFormPOJO formdata, String username);
	ApplicantFormPOJO updateApplicantForm(ApplicantFormPOJO formdata, String username, Long formId);
	Country getCountry(long id);
	Category getCategory(long id);
	//fix deposit amount?
	Transaction peformTransaction(String username, ApplicantFormPOJO savedFormData);
	Users registerUser(Users user); 
	Users checkRegisteredEmail(String email);
	Users getUser(String username);
}
