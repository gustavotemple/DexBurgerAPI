package com.dexburger.prices.service;

import com.dexburger.burgers.model.Burger;
import com.dexburger.exceptions.IngredientNotFoundException;
import com.dexburger.order.model.Order;

public interface PriceService {

	Burger calculatePrice(Burger burger);

	Burger calculatePrice(Order order);

	void applyDiscount(Burger burger);

	void applyDiscount(Order order);
}
