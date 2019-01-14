package com.my.longtail.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.my.longtail.model.Franchise;
import com.my.longtail.model.FranchiseStatus;
import com.my.longtail.model.Users;
import com.my.longtail.repositories.FranchiseRepository;
import com.my.longtail.repositories.UsersRepository;


public class ScheduleTask {
	@Autowired
	private FranchiseRepository franchiseRepository;
	
	@Autowired
	private UsersRepository userRepository;

	public void setParticipantToFranchise() {
		List<Users> participantInHolding;
		List<Franchise> franchiseList = franchiseRepository.findAllByFranchiseStatus(FranchiseStatus.PARTICIPANT_NEEDED);
		if(franchiseList.size() > 0) {
			for(Franchise franchise : franchiseList) {
				
			}
		}
	}
}
