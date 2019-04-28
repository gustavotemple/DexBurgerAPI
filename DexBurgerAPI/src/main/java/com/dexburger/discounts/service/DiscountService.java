package com.dexburger.discounts.service;

import com.dexburger.burgers.model.Burger;
import com.dexburger.order.model.Order;

public interface DiscountService {
	
	Burger applyDiscount(Burger burger);
	
	Order applyDiscount(Order order);
}
