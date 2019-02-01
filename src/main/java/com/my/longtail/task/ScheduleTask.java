package com.my.longtail.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.my.longtail.logger.Logger;
import com.my.longtail.model.ApplicantFormPOJO;
import com.my.longtail.model.ApplicantStatus;
import com.my.longtail.model.Franchise;
import com.my.longtail.model.FranchiseStatus;
import com.my.longtail.model.Role;
import com.my.longtail.model.Users;
import com.my.longtail.model.Users_ApplicantForms;
import com.my.longtail.model.Users_Franchises;
import com.my.longtail.repositories.ApplicantFormRepository;
import com.my.longtail.repositories.FranchiseRepository;
import com.my.longtail.repositories.RoleRepository;
import com.my.longtail.repositories.UserApplicantFormRepository;
import com.my.longtail.repositories.UserFranchiseRepository;
import com.my.longtail.repositories.UsersRepository;


public class ScheduleTask {
	@Autowired
	private FranchiseRepository franchiseRepository;
	
	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private UserApplicantFormRepository userApplicantFormRepository;
	
	@Autowired
	private UserFranchiseRepository userFranchiseRepository;
	
	@Autowired
	private ApplicantFormRepository applicantFormRepository;
	
	@Autowired
	private RoleRepository roleRepository;

	@Transactional(rollbackFor = Exception.class)
	public void setParticipantToFranchise() {
		List<Users> participantInHolding = userRepository.findByUserApplicantForm_ApplicantStatusOrderByUserApplicantForm_ApplicantForm_DateSubmitted(ApplicantStatus.PENDING_ASSIGN);
		
		List<Franchise> franchiseList = franchiseRepository.findAllByFranchiseStatus(FranchiseStatus.PARTICIPANT_NEEDED);
		System.out.println("Size "+franchiseList.size());
		if(participantInHolding.size() > 0) {
			if(franchiseList.size() > 0) {
				for(Users user : participantInHolding) {
					List<ApplicantFormPOJO> applicantForms = applicantFormRepository.
							findByUserApplicantForm_User_IdAndUserApplicantForm_ApplicantStatusOrderByDateSubmittedAsc(user.getId(), ApplicantStatus.PENDING_ASSIGN);
					System.out.println("number of forms "+applicantForms.size());
					for(Franchise franchise : franchiseList) {
						if(franchise.getInvestParticipantNeeded() > 0) {
							Users_Franchises userFranchise = new Users_Franchises();
							for(ApplicantFormPOJO applicantForm : applicantForms) {
								userFranchise.setFranchise(franchise);
								userFranchise.setUser(user);
								if(franchise.getManagementParticipantNeeded() > 0) {
									userFranchise.setFranchise(franchise);
									userFranchise.setUser(user);
									if(applicantForm.isManagementParticipation()) {
										Role role = roleRepository.findByRole(Role.ROLE_MANAGEMEN);
										userFranchise.setRole(role);
										franchise.setManagementParticipantNeeded(franchise.getManagementParticipantNeeded()-1);
									}
									if(userFranchiseRepository.save(userFranchise) == null) 
										throw new IllegalArgumentException("Fail to save user franchise");
									
									franchise.setInvestParticipantNeeded(franchise.getInvestParticipantNeeded()-1);
									if(franchiseRepository.save(franchise) == null)
										throw new IllegalArgumentException("Fail to save franchise");
								}
							}	
						}
					}
				}
			}else {
//				Logger.writeActivity("No Franchise Up at the moment", foldername);
			}
		}else {
//			Logger.writeActivity("No Participants at the moment", foldername);
		}
	}
}
