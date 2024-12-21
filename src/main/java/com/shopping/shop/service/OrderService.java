package com.shopping.shop.service;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.shopping.base.service.BaseService;
import com.shopping.shop.entity.Cart;
import com.shopping.shop.entity.Order;
import com.shopping.shop.entity.OrderItem;
import com.shopping.shop.entity.Product;
import com.shopping.shop.enums.OrderStatus;
import com.shopping.shop.repository.OrderRepository;
import lombok.extern.log4j.Log4j2;


@Log4j2
@Service
public class OrderService extends BaseService<Order, Long> {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private ProductService productService;
	
	public OrderService() {
		super(Order.class);
	}
	
	public Order palceOrder(Long userId) {
		
		Cart cart = cartService.findByAppUserId(userId);
		Order order = createOrder(cart);
		List<OrderItem> orderItemList = createOrderItems(order, cart);
		order.setOrderItems(new HashSet<>(orderItemList));
		order.setTotalAmount(cart.getTotalAmount());
		Order savedOrder = orderRepository.save(order);
        cartService.clearCart(cart.getId());
        
        return savedOrder;
	}

	private List<OrderItem> createOrderItems(Order order, Cart cart) {
		
		return cart.getItems()
				.stream()
				.map(cartItem -> {
		            Product product = cartItem.getProduct();
		            product.setInventory(product.getInventory() - cartItem.getQuantity());
		            productService.insert(product);
		            return  new OrderItem(
	                    order,
	                    product,
	                    cartItem.getQuantity(),
	                    cartItem.getUnitPrice());
				}).collect(Collectors.toList());
	}

	private Order createOrder(Cart cart) {
		
		Order order = new Order();
		order.setUser(cart.getUser());
		order.setOrderStatus(OrderStatus.PENDING);
		order.setOrderDate(LocalDate.now());
		
		return order;
	}
	
	public List<Order> getUserOrders(Long userId) {
		
        return orderRepository.findByUserId(userId);
    }
}