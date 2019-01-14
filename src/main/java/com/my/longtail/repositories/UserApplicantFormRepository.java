package com.my.longtail.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.longtail.model.Users_ApplicantForms;

@Repository("userApplicantFormRepository")
public interface UserApplicantFormRepository extends JpaRepository<Users_ApplicantForms, Long>{
	
}
