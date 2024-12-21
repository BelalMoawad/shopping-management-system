package com.shopping.shop.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.shop.dto.ProductDto;
import com.shopping.shop.entity.Product;
import com.shopping.shop.mapper.ProductMapper;
import com.shopping.shop.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/product")
@RequiredArgsConstructor
public class ProductController {
	
	private final ProductService productService;

	private final ProductMapper productMapper;
	
	@PostMapping("")
	public ResponseEntity<?> insert(@RequestBody Product product) {
		ProductDto productDto = productMapper.map(productService.insert(product));
		return ResponseEntity.ok(productDto);
	}
	
	@PutMapping("")
	public ResponseEntity<?> update(@RequestBody Product product) {
	    ProductDto productDto = productMapper.map(productService.update(product));
	    return ResponseEntity.ok(productDto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id) {
		ProductDto productDto = productMapper.map(productService.findById(id));
		return ResponseEntity.ok(productDto);
	}
	
	@GetMapping("/cat_name/{categoryName}")
	public ResponseEntity<?> findByCategoryName(@PathVariable String categoryName) {
		List<ProductDto> productDtos = productMapper.map(productService.findByCategoryName(categoryName));
		return  ResponseEntity.ok(productDtos);	
	}
	
	@GetMapping("/brand/{brand}")
	public ResponseEntity<?> findByBrand(@PathVariable String brand) {
		List<ProductDto> productDtos = productMapper.map(productService.findByBrand(brand));
		return  ResponseEntity.ok(productDtos);	
	}
	
	@GetMapping("/cat_name_and_brand")
	public ResponseEntity<?> findByCategoryNameAndBrand(@RequestParam String categoryName, @RequestParam String brand) {
		List<ProductDto> productDtos = productMapper.map(productService.findByCategoryNameAndBrand(categoryName, brand));
		return  ResponseEntity.ok(productDtos);	
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<?> findByName(@PathVariable String name) {
		List<ProductDto> productDtos = productMapper.map(productService.findByName(name));
		return  ResponseEntity.ok(productDtos);	
	}
	
	@GetMapping("/brand_and_name")
	public ResponseEntity<?> findByBrandAndName(@RequestParam String brand, @RequestParam String name) {
		List<ProductDto> productDtos = productMapper.map(productService.findByBrandAndName(brand, name));
		return  ResponseEntity.ok(productDtos);	
	}
	
	@GetMapping("/brand_and_name/count")
	public ResponseEntity<?> countByBrandAndName(@RequestParam String brand, @RequestParam String name) {
		return  ResponseEntity.ok(productService.countByBrandAndName(brand, name));	
	}

}
