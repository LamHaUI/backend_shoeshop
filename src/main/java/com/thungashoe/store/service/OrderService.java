package com.thungashoe.store.service;

import java.util.List;

import com.thungashoe.store.domain.Order;
import com.thungashoe.store.domain.Shipping;
import com.thungashoe.store.domain.ShoppingCart;
import com.thungashoe.store.domain.User;

public interface OrderService {
	List<Order> findAllOrders();

	Order getById(Long id);

	void updateOrder(Order order);

	Order createOrder(ShoppingCart shoppingCart, Shipping shippingAddress, User user);
	
	List<Order> findByUser(User user);
	
	Order findOrderWithDetails(Long id);

}
