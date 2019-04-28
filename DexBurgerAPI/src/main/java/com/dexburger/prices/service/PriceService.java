package com.dexburger.prices.service;

import java.math.BigDecimal;

import com.dexburger.burgers.model.Burger;
import com.dexburger.order.model.Order;

public interface PriceService {

	BigDecimal calculatePrice(Burger burger);

	BigDecimal calculatePrice(Order order);

	void applyDiscount(Burger burger);

	void applyDiscount(Order order);
}
