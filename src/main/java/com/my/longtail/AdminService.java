package com.my.longtail;

import java.util.List;

import com.my.longtail.model.Category;
import com.my.longtail.model.Franchise;

public interface AdminService {
	Franchise saveFranchise(Franchise franchise);
	Franchise updateFranchise(Franchise franchise);
	boolean removeFranchise(long franchiseId);
	List<Franchise> getAllFranchise();
	List<Category> getAllCategories();
	Category getCategory(long categoryId);
}
