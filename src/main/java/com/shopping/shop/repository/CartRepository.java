package com.shopping.shop.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.shopping.base.repository.BaseRepository;
import com.shopping.shop.entity.Cart;

@Repository
public interface CartRepository extends BaseRepository<Cart, Long> {
	
	@Query("SELECT crt FROM Cart crt WHERE crt.user.id = :id")
	Cart findByUserId(Long id);
}
