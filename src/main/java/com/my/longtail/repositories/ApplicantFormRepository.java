package com.my.longtail.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.longtail.model.ApplicantFormPOJO;

@Repository("applicantFormRepository")
public interface ApplicantFormRepository extends JpaRepository<ApplicantFormPOJO, Long>{

}
