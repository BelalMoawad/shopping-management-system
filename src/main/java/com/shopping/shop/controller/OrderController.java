package com.shopping.shop.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.shopping.shop.dto.OrderDto;
import com.shopping.shop.entity.Order;
import com.shopping.shop.mapper.OrderMapper;
import com.shopping.shop.service.OrderService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("${api.prefix}/order")
@RequiredArgsConstructor
public class OrderController {
	
	private final OrderService orderService;

	private final OrderMapper orderMapper;
	
	@GetMapping("/{orerId}")
	public ResponseEntity<?> findById(@PathVariable Long orerId) {
		OrderDto orderDto = orderMapper.map(orderService.findById(orerId));
		return ResponseEntity.ok(orderDto);
	}
	
	@PostMapping("/user/{userId}")
	public ResponseEntity<?> createOrder(@PathVariable Long userId) {
		OrderDto orderDto = orderMapper.map(orderService.palceOrder(userId));
		return ResponseEntity.ok(orderDto);
	}
	
	@GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserOrders(@PathVariable Long userId) {
		List<OrderDto> orderDtos = orderMapper.map(orderService.getUserOrders(userId));
		return ResponseEntity.ok(orderDtos);
    }

}
