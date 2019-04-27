package com.dex.burger.service;

import java.util.Collection;

import com.dex.burger.models.burger.Burger;
import com.dex.burger.models.order.Order;
import com.dex.burger.models.order.OrderDTO;

public interface OrderService {

	public Order addOrder(OrderDTO orderDTO);

	public Order getOrder(Long orderId);

	public Order updateOrder(Long orderId, Order order);

	public void deleteOrder(Long orderId);
	
	public Collection<Burger> getBurgersByOrder(Long orderId);

	public Collection<Order> findAll();
}
