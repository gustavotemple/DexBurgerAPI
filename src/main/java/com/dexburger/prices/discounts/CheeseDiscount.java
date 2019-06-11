package com.dexburger.prices.discounts;

import org.springframework.stereotype.Component;

import com.dexburger.burgers.model.Burger;
import com.dexburger.ingredients.IngredientsInfo;

@Component
public class CheeseDiscount extends QuantityDiscount {

	private static final String DISCOUNT_NAME = CheeseDiscount.class.getSimpleName();
	private static final IngredientsInfo INGREDIENT = IngredientsInfo.CHEESE;
	private static final int QUANTITY = 3;

	@Override
	public void apply(final Burger burger) {
		apply(burger, INGREDIENT, DISCOUNT_NAME, QUANTITY);
	}

}
