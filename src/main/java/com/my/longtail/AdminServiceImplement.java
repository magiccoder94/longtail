package com.my.longtail;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.longtail.logger.Logger;
import com.my.longtail.model.Category;
import com.my.longtail.model.Franchise;
import com.my.longtail.property.Property;
import com.my.longtail.repositories.CategoryRepository;
import com.my.longtail.repositories.FranchiseRepository;

@Service("adminServiceImplement")
public class AdminServiceImplement implements AdminService{
	
	@Autowired
	FranchiseRepository franchiseRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	final static String foldername = Property.getWEBPORTAL_FOLDER_NAME();
	
	@Override
	public Franchise saveFranchise(Franchise franchise) {
		return franchiseRepository.save(franchise);
	}

	@Override
	public Franchise updateFranchise(Franchise franchise) {
		Franchise existing = franchiseRepository.getOne(franchise.getId());
		
		if(existing == null)
			return null;
		
		franchise.merge(existing);
		return franchiseRepository.save(existing);
	}

	@Override
	public boolean removeFranchise(long franchiseId) {
		Franchise franchise = franchiseRepository.getOne(franchiseId);
		if(franchise == null)
			return false;
		try {
			franchiseRepository.delete(franchise);
		}catch(Exception e) {
			e.printStackTrace();
			Logger.writeError(e, "Exception: ", foldername);
			return false;
		}
		return true;
	}

	@Override
	public List<Franchise> getAllFranchise() {
		return franchiseRepository.findAllOrderByDateCreatedAsc();
	}

	@Override
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getCategory(long categoryId) {
		return categoryRepository.getOne(categoryId);
	}
	
}
