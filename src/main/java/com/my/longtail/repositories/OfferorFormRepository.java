package com.my.longtail.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.longtail.model.OfferorForm;

@Repository("offerorFormRepository")
public interface OfferorFormRepository extends JpaRepository<OfferorForm, Long>{

}
