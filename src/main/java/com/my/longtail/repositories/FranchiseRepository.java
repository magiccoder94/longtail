package com.my.longtail.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.longtail.model.Category;
import com.my.longtail.model.Franchise;
import com.my.longtail.model.FranchiseType;

@Repository("franchiseRepository")
public interface FranchiseRepository extends JpaRepository<Franchise, Long>{
	//top 5 popular list
	List<Franchise> findTop5ByOrderByInvestorInterestedDesc();
	//top 5 by franchise type
	List<Franchise> findTop5ByFranchiseTypeAndOrderByInvestorInterestedDesc(FranchiseType franchiseType);
	//top 5 latest list
	List<Franchise> findAllTop5ByOrderByDateCreatedAsc();
	//top 5 by recommended latest list
	List<Franchise> findTop5ByCategoryOrderByDateCreatedAsc(Category category);
	//all latest list non-pageable
	List<Franchise> findAllByOrderByDateCreatedAsc();
	
	//latest list
	Page<Franchise> findAllByOrderByDateCreatedAsc(Pageable pageable);
	//popular list
	Page<Franchise> findAllByOrderByInvestorInterestedDesc(Pageable pageable);
	//by franchise type
	Page<Franchise> findAllByFranchiseTypeAndOrderByInvestorInterestedDesc(FranchiseType franchiseType, Pageable pageable);
	//by category for recommended list
	Page<Franchise> findAllByCategoryAndOrderByInvestorInterestedDesc(Category category, Pageable pageable);
	
}
