package com.shopping.shop.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.shopping.base.repository.BaseRepository;
import com.shopping.shop.entity.Order;


@Repository
public interface OrderRepository extends BaseRepository<Order, Long> {
	
	List<Order> findByUserId(Long id);
	
}
