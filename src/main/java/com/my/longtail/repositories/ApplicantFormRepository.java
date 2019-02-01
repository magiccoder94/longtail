package com.my.longtail.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.longtail.model.ApplicantFormPOJO;
import com.my.longtail.model.ApplicantStatus;

@Repository("applicantFormRepository")
public interface ApplicantFormRepository extends JpaRepository<ApplicantFormPOJO, Long>{
	List<ApplicantFormPOJO> findByUserApplicantForm_User_IdAndUserApplicantForm_ApplicantStatusOrderByDateSubmittedAsc(long id, ApplicantStatus applicantStatus);
}
