package com.my.longtail.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.longtail.model.Category;
import com.my.longtail.model.Franchise;
import com.my.longtail.model.FranchiseStatus;
import com.my.longtail.model.FranchiseType;

@Repository("franchiseRepository")
public interface FranchiseRepository extends JpaRepository<Franchise, Long>{
	//top 5 popular list
//	List<Franchise> findTop5ByOrderByInvestorInterestedDesc();
	//top 5 by franchise type
//	List<Franchise> findTop5ByFranchiseTypeOrderByInvestorInterestedDesc(FranchiseType franchiseType);
	//top 5 latest list
//	List<Franchise> findAllTop5ByOrderByDateCreatedAsc();
	//top 5 by recommended latest list
//	List<Franchise> findTop5ByCategory_IdOrderByDateCreatedAsc(long categoryId);
	//all latest list non-pageable
//	List<Franchise> findAllByOrderByDateCreatedAsc();
	
	//latest list
//	Page<Franchise> findAllByOrderByDateCreatedAsc(Pageable pageable);
	//popular list
//	Page<Franchise> findAllByOrderByInvestorInterestedDesc(Pageable pageable);
	//by franchise type
//	Page<Franchise> findByFranchiseTypeOrderByInvestorInterestedDesc(FranchiseType franchiseType, Pageable pageable);
	//by category for recommended list
//	Page<Franchise> findAllByCategory_IdOrderByInvestorInterestedDesc(long categoryId, Pageable pageable);
	
	
	List<Franchise> findAllByOrderByDateCreatedAsc();
	List<Franchise> findAllByFranchiseStatus(FranchiseStatus franchiseStatus);
}
