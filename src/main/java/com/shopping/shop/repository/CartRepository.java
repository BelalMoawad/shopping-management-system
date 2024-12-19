package com.shopping.shop.repository;

import org.springframework.stereotype.Repository;
import com.shopping.base.repository.BaseRepository;
import com.shopping.shop.entity.Cart;

@Repository
public interface CartRepository extends BaseRepository<Cart, Long> {
	
	Cart findByUserId(Long id);
}
