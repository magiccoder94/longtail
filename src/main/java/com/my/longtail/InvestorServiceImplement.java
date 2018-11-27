package com.my.longtail;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.my.longtail.logger.Logger;
import com.my.longtail.model.ApplicantFormPOJO;
import com.my.longtail.model.Category;
import com.my.longtail.model.Franchise;
import com.my.longtail.model.Users;
import com.my.longtail.property.Property;
import com.my.longtail.repositories.ApplicantFormRepository;
import com.my.longtail.repositories.CategoryRepository;
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
	
	final static String foldername = Property.getWEBPORTAL_FOLDER_NAME();
	
	@Transactional
	@Override
	public Franchise setInterestedFranchise(long franchiseId, String username) {
		Users user = userRepository.findByUsername(username);
		if(user == null) {
			Logger.writeActivity("Could not find user", foldername);
			return null;
		}
		Franchise franchise = franchiseRepository.getOne(franchiseId);
		if(franchise == null) {
			Logger.writeActivity("Could not find franchise", foldername);
			return null;
		}
		franchise.setInvestorInterested(franchise.getInvestorInterested()+1);
		Set<Users> userSet = franchise.getUsers();
		userSet.add(user);
		franchise.setUsers(userSet);
		return franchiseRepository.save(franchise);
	}

	@Transactional
	@Override
	public Franchise setUninterestFranchise(long franchiseId, String username) {
		Users user = userRepository.findByUsername(username);
		if(user == null) {
			Logger.writeActivity("Could not find user", foldername);
			return null;
		}
		Franchise franchise = franchiseRepository.getOne(franchiseId);
		if(franchise == null) {
			Logger.writeActivity("Could not find franchise", foldername);
			return null;
		}
		franchise.setInvestorInterested(franchise.getInvestorInterested()-1);
		Set<Users> userSet = franchise.getUsers();
		userSet.remove(user);
		franchise.setUsers(userSet);
		return franchiseRepository.save(franchise);
	}
	
	@Override
	public Page<Franchise> getFranchiseList(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Franchise> getAllPopularFranchise(Pageable pageable) {
		return franchiseRepository.findAllByOrderByInvestorInterestedDesc(pageable);
	}

	@Override
	public Page<Franchise> getAllRecommendedFranchiseType(String username, Pageable pageable) {
		Users user = userRepository.findByUsername(username);
		if(user == null) {
			Logger.writeActivity("fail to find user", foldername);
			return null;
		}
		ApplicantFormPOJO formData = applicantFormRepository.getOne(user.getFormData().getId());
		if(formData == null) {
			Logger.writeActivity("could not find form data", foldername);
			return null;
		}
			
		return franchiseRepository.findAllByFranchiseTypeAndOrderByInvestorInterestedDesc(formData.getInterestedFranchise(), pageable);
	}
	
	@Override
	public Page<Franchise> getAllFranchiseByCategory(long categoryId, Pageable pageable) {
		Category category = categoryRepository.getOne(categoryId);
		if(category == null) {
			Logger.writeActivity("could not find category", foldername);
			return null;
		}
		return franchiseRepository.findAllByCategoryAndOrderByInvestorInterestedDesc(category, pageable);
	}

	@Override
	public Page<Franchise> getAllLatestFranchise(Pageable pageable) {
		return franchiseRepository.findAllByOrderByDateCreatedAsc(pageable);
	}

	@Override
	public List<Franchise> getTop5PopularFranchise() {
		return franchiseRepository.findTop5ByOrderByInvestorInterestedDesc();
	}

	@Override
	public List<Franchise> getTop5RecommendedFranchiseNByFranchiseType(String username) {
		Users user = userRepository.findByUsername(username);
		if(user == null) {
			Logger.writeActivity("fail to find user", foldername);
			return null;
		}
		ApplicantFormPOJO formData = applicantFormRepository.getOne(user.getFormData().getId());
		if(formData == null) {
			Logger.writeActivity("could not find form data", foldername);
			return null;
		}
		
		return franchiseRepository.findTop5ByFranchiseTypeAndOrderByInvestorInterestedDesc(formData.getInterestedFranchise());
	}

	@Override
	public List<Franchise> getRop5LatestFranchise() {
		return franchiseRepository.findAllTop5ByOrderByDateCreatedAsc();
	}

	@Transactional
	@Override
	public ApplicantFormPOJO saveApplicantForm(ApplicantFormPOJO applicantForm, String username) {
		ApplicantFormPOJO savedApplicantForm = null;
		try {
			Users user = userRepository.findByUsername(username);
			if(user == null) {
				Logger.writeActivity("fail to find user", foldername);
				return null;
			}
			savedApplicantForm = applicantFormRepository.save(applicantForm);
			if(savedApplicantForm == null) {
				Logger.writeActivity("fail to save applicant form", foldername);
				return null;
			}
			user.setFormData(savedApplicantForm);
			if(userRepository.save(user) == null) {
				Logger.writeActivity("fail to save user form info", foldername);
				return null;
			}
		}catch(Exception e) {
			Logger.writeError(e, "Exception: ", foldername);
			throw new IllegalArgumentException("Error storing applicant form data.");
		}
		
		return savedApplicantForm;
	}

	@Transactional
	@Override
	public ApplicantFormPOJO updateApplicantForm(ApplicantFormPOJO applicantForm, String username) {
		Users user = userRepository.findByUsername(username);
		if(user == null) {
			Logger.writeActivity("fail to find user", foldername);
			return null;
		}
		ApplicantFormPOJO existing = applicantFormRepository.getOne(applicantForm.getId());
		if(existing == null) {
			Logger.writeActivity("fail to find applicant form data", foldername);
			return null;
		}
		applicantForm.merge(existing);
		
		return applicantFormRepository.save(existing);
	}

}
