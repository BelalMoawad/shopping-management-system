package com.shopping.shop.repository;

import org.springframework.stereotype.Repository;
import com.shopping.base.repository.BaseRepository;
import com.shopping.shop.entity.Category;
import com.shopping.shop.entity.Product;

import lombok.RequiredArgsConstructor;

@Repository
public interface CategoryRepository extends BaseRepository<Category, Long> {
	
	Category findByName(String name);
	
}
