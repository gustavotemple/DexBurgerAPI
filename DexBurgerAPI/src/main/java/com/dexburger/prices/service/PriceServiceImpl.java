package com.dexburger.prices.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.dexburger.burgers.model.Burger;
import com.dexburger.exceptions.IngredientNotFoundException;
import com.dexburger.ingredients.model.Ingredient;
import com.dexburger.order.model.Order;

@Service
public class PriceServiceImpl implements PriceService {

	@Override
	public BigDecimal calculatePrice(Burger burger) throws IngredientNotFoundException {
		if (CollectionUtils.isEmpty(burger.getIngredients()))
			throw new IngredientNotFoundException();

		BigDecimal sum = burger.getIngredients().stream()
				.map(Ingredient::getPrice)
				.reduce(BigDecimal.ZERO, BigDecimal::add);

		return sum;
	}

	@Override
	public BigDecimal calculatePrice(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void applyDiscount(Burger burger) {
		// TODO Auto-generated method stub

	}

	@Override
	public void applyDiscount(Order order) {
		// TODO Auto-generated method stub

	}
}
