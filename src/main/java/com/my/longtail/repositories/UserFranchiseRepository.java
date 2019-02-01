package com.my.longtail.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.longtail.model.Users_Franchises;

@Repository("userFranchiseRepository")
public interface UserFranchiseRepository extends JpaRepository<Users_Franchises, Long>{
	Users_Franchises findByFranchise_Id(long id);
	List<Users_Franchises> findByUser_Id(long id);
}
