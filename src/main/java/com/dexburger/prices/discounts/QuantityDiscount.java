package com.dexburger.prices.discounts;

import java.math.BigDecimal;

import com.dexburger.burgers.model.Burger;
import com.dexburger.ingredients.IngredientsInfo;

public abstract class QuantityDiscount {

	public abstract void apply(final Burger burger);

	protected void apply(final Burger burger, final IngredientsInfo ingredient, final String DiscountName,
			final int quantity) {
		long total = burger.getIngredients().stream().filter(ingredient.getPredicate()).count();

		long pay = total - (total / quantity);

		long diff = total - pay;

		burger.setPrice(
				burger.getPrice().subtract(ingredient.getIngredient().getPrice().multiply(new BigDecimal(diff))));

		if (total >= quantity)
			burger.addDiscount(DiscountName);
	}

}
