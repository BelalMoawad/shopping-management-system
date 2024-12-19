package com.shopping.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopping.base.service.BaseService;
import com.shopping.shop.entity.Category;
import com.shopping.shop.entity.Product;
import com.shopping.shop.exception.ResourceNotFoundException;
import com.shopping.shop.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
public class ProductService extends BaseService<Product, Long>{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryService categoryService;
	
	public ProductService() {
		super(Product.class);
	}
	
	public Product insert(Product product) {
		if(product.getCategory() != null && product.getCategory().getId() != null)
			product.setCategory(categoryService.findById(product.getCategory().getId()));
		return productRepository.save(product);
	}
	
	public Product update(Product product) {
		Optional<Product> prOptional = productRepository.findById(product.getId());
		Product existingProduct = prOptional.orElseThrow(() -> 
        new ResourceNotFoundException("Product not found with id: " + product.getId()));
	    // Update existing product details
	    existingProduct.setName(product.getName());
	    existingProduct.setBrand(product.getBrand());
	    existingProduct.setPrice(product.getPrice());
	    existingProduct.setInventory(product.getInventory());
	    existingProduct.setDescription(product.getDescription());
	    
	    
	    return productRepository.save(existingProduct);
	}
	
	public List<Product> findByCategoryName(String categoryName) {
		return productRepository.findByCategoryName(categoryName);	
	}
	
	public List<Product> findByBrand(String brand) {
		return productRepository.findByBrand(brand);
	}
	
	public List<Product> findByCategoryNameAndBrand(String categoryName, String brand) {
		return productRepository.findByCategoryNameAndBrand(categoryName, brand);
	}
	
	public List<Product> findByName(String name) {
		return productRepository.findByName(name);
	}
	
	public List<Product> findByBrandAndName(String brand, String name) {
		return productRepository.findByBrandAndName(brand, name);
	}
	
	public Long countByBrandAndName(String brand, String name) {
		return productRepository.countByBrandAndName(brand, name);
	}
}
