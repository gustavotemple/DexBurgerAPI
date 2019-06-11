package com.dexburger.prices.discounts;

import org.springframework.stereotype.Component;

import com.dexburger.burgers.model.Burger;
import com.dexburger.ingredients.IngredientsInfo;

@Component
public class MeatDiscount extends QuantityDiscount {
	
	private static final String DISCOUNT_NAME = MeatDiscount.class.getSimpleName();
	private static final IngredientsInfo INGREDIENT = IngredientsInfo.MEAT;
	private static final int QUANTITY = 3;
	
	@Override
	public void apply(final Burger burger) {
		apply(burger, INGREDIENT, DISCOUNT_NAME, QUANTITY);
	}

}
