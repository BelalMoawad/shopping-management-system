package com.shopping.shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopping.base.service.BaseService;
import com.shopping.shop.entity.Category;
import com.shopping.shop.exception.ResourceNotFoundException;
import com.shopping.shop.repository.CategoryRepository;


@Service
public class CategoryService extends BaseService<Category, Long> {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public CategoryService() {
		super(Category.class);
	}
	
	public Category insert(Category category) {
		return categoryRepository.save(category);
	}
	
	public Category update(Category category) {
		Optional<Category> prOptional = categoryRepository.findById(category.getId());
		Category existingCategory = prOptional.orElseThrow(() -> 
        new ResourceNotFoundException("Category not found with id: " + category.getId()));
	    // Update existing category details
	    existingCategory.setName(category.getName());
	    
	    return categoryRepository.save(existingCategory);
	}
	
	public Category findByName(String name) {
		return categoryRepository.findByName(name);
	}
	
}