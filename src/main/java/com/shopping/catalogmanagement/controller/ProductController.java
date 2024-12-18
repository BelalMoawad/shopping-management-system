package com.shopping.catalogmanagement.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shopping.catalogmanagement.dto.ProductDto;
import com.shopping.catalogmanagement.mapper.ProductMapper;
import com.shopping.catalogmanagement.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductMapper productMapper;
	
	@GetMapping("")
	public ResponseEntity<?> findAll() {
		List<ProductDto> productDtos = productMapper.map(productService.findAll());
		return ResponseEntity.ok(productDtos);
	}
	
}
