package com.dexburger.prices.service;

import com.dexburger.burgers.model.Burger;
import com.dexburger.order.model.Order;

public interface PriceService {

	void calculatePrice(Burger burger);

	void calculatePrice(Order order);

	void applyDiscounts(Burger burger);
}
