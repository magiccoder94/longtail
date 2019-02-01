package com.my.longtail.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.longtail.model.ApplicantStatus;
import com.my.longtail.model.Users;

@Repository("usersRepository")
public interface UsersRepository extends JpaRepository<Users, Long>{
	Users findByUsername(String username); 
	//order by date submitted
	List<Users> findByUserApplicantForm_ApplicantStatusOrderByUserApplicantForm_ApplicantForm_DateSubmitted(ApplicantStatus applicantStatus);
}
