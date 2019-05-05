package com.dexburger.order.service;

import java.util.Collection;

import com.dexburger.burgers.model.Burger;
import com.dexburger.order.dto.OrderDTO;
import com.dexburger.order.model.Order;

public interface OrderService {

	Order addOrder(OrderDTO orderDTO);

	Order getOrder(Long orderId);

	Order updateOrder(Long orderId, OrderDTO orderDTO);

	void deleteOrder(Long orderId);
	
	Collection<Burger> getBurgersByOrder(Long orderId);

	Collection<Order> findAll();
}
