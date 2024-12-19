package com.shopping.shop.repository;

import org.springframework.stereotype.Repository;
import com.shopping.base.repository.BaseRepository;
import com.shopping.shop.entity.CartItem;

@Repository
public interface CartItemRepository extends BaseRepository<CartItem, Long> {
	
	void deleteAllByCartId(Long id);
	
}
