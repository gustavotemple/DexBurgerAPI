package com.dexburger.order.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.dexburger.order.model.Order;

@Repository
public class OrderRepository {

	private List<Order> orders = new ArrayList<>();;

	public List<Order> findAll() {
		return orders;
	}

	public Optional<Order> findById(Long id) {
		return orders.stream().filter(i -> id.equals(i.get_id())).findAny();
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
