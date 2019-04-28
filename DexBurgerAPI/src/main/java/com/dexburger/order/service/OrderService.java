package com.dexburger.order.service;

import java.util.Collection;

import com.dexburger.burgers.model.Burger;
import com.dexburger.order.model.Order;
import com.dexburger.order.model.OrderDTO;

public interface OrderService {

	Order addOrder(OrderDTO orderDTO);

	Order getOrder(Long orderId);

	Order updateOrder(Long orderId, Order order);

	void deleteOrder(Long orderId);
	
	Collection<Burger> getBurgersByOrder(Long orderId);

	Collection<Order> findAll();
}
