package com.my.longtail;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.my.longtail.model.ApplicantFormPOJO;
import com.my.longtail.model.Franchise;

public interface InvestorService {
	Franchise setInterestedFranchise(long franchiseId, String username);
	Franchise setUninterestFranchise(long franchiseId, String username);
	Page<Franchise> getFranchiseList(Pageable pageable);
	Page<Franchise> getAllPopularFranchise(Pageable pageable);
	Page<Franchise> getAllRecommendedFranchiseType(String username, Pageable pageable);
	Page<Franchise> getAllFranchiseByCategory(long categoryId, Pageable pageable);
	Page<Franchise> getAllLatestFranchise(Pageable pageable);
	List<Franchise> getTop5PopularFranchise();
	List<Franchise> getTop5RecommendedFranchiseNByFranchiseType(String username);
	List<Franchise> getRop5LatestFranchise();
	ApplicantFormPOJO saveApplicantForm(ApplicantFormPOJO applicantForm, String username);
	ApplicantFormPOJO updateApplicantForm(ApplicantFormPOJO applicantForm, String username);
}
