package com.my.longtail.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.longtail.model.Country;

@Repository("countryRepository")
public interface CountryRepository extends JpaRepository<Country, Long>{
	
}
