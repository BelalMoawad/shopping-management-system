package com.shopping.catalogmanagement.repository;

import org.springframework.stereotype.Repository;

import com.shopping.base.repository.BaseRepository;
import com.shopping.catalogmanagement.entity.Product;

@Repository
public interface ProductRepository extends BaseRepository<Product, Long> {
	
}
