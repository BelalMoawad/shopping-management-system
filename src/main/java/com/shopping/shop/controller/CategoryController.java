package com.shopping.shop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.shop.dto.CategoryDto;
import com.shopping.shop.mapper.CategoryMapper;
import com.shopping.shop.service.CategoryService;

@RestController
@RequestMapping("${api.prefix}/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@GetMapping("")
	public ResponseEntity<?> findAll() {
		List<CategoryDto> categoryDtos = categoryMapper.map(categoryService.findAll());
		return ResponseEntity.ok(categoryDtos);
	}
	
}
