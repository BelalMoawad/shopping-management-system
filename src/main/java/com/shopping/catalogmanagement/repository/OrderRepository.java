package com.shopping.catalogmanagement.repository;

import org.springframework.stereotype.Repository;

import com.shopping.base.repository.BaseRepository;
import com.shopping.catalogmanagement.entity.Order;

@Repository
public interface OrderRepository extends BaseRepository<Order, Long> {
	
}
