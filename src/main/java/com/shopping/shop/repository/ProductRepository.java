package com.shopping.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.base.repository.BaseRepository;
import com.shopping.shop.entity.Product;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long> {
	
	List<Product> findByCategoryName(String categoryName);
	
	List<Product> findByBrand(String brand);
	
	List<Product> findByCategoryNameAndBrand(String categoryName, String brand);
	
	List<Product> findByName(String name);
	
	List<Product> findByBrandAndName(String brand, String name);
	
	Long countByBrandAndName(String brand, String name);
	
}
