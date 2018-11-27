package com.my.longtail.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.my.longtail.model.Category;

@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
