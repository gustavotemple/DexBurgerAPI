package com.dex.burger.repositories;

import java.util.ArrayList;
import java.util.List;

import com.dex.burger.models.order.Order;

public final class OrderRepository {

	private static OrderRepository instance;

	private List<Order> orders;

	private OrderRepository() {
		orders = new ArrayList<Order>();
	}

	public static OrderRepository getInstance() {
		if (instance == null)
			instance = new OrderRepository();
		return instance;
	}

	public List<Order> findAll() {
		return orders;
	}

	public Order findById(Long id) {
		return orders.stream().filter(i -> id.equals(i.getId())).findAny().orElse(null);
	}

	public void add(Order order) {
		orders.add(order);
	}

	public void remove(Order order) {
		orders.remove(order);
	}

	public void update(Order order) {
		int i = orders.indexOf(order);
		orders.set(i, order);
	}

}
