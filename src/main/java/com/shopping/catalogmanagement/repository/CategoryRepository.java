package com.shopping.catalogmanagement.repository;

import org.springframework.stereotype.Repository;
import com.shopping.base.repository.BaseRepository;
import com.shopping.catalogmanagement.entity.Category;

@Repository
public interface CategoryRepository extends BaseRepository<Category, Long> {
	
}
