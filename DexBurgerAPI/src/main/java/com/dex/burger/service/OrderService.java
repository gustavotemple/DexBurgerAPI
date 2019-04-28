package com.dex.burger.service;

import java.util.Collection;

import com.dex.burger.models.burger.Burger;
import com.dex.burger.models.order.Order;
import com.dex.burger.models.order.OrderDTO;

public interface OrderService {

	Order addOrder(OrderDTO orderDTO);

	Order getOrder(Long orderId);

	Order updateOrder(Long orderId, Order order);

	void deleteOrder(Long orderId);
	
	Collection<Burger> getBurgersByOrder(Long orderId);

	Collection<Order> findAll();
}
