package com.dexburger.prices.discounts;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.dexburger.burgers.model.Burger;
import com.dexburger.ingredients.IngredientsInfo;

@Component
public class LightDiscount implements PercentageDiscount {

	private static final String DISCOUNT_NAME = LightDiscount.class.getSimpleName();
	public static final BigDecimal DISCOUNT = new BigDecimal(10);

	@Override
	public void apply(final Burger burger) {
		if (burger.getIngredients().contains(IngredientsInfo.LETUCE.getIngredient())
				&& !burger.getIngredients().contains(IngredientsInfo.BACON.getIngredient())) {
			burger.setPrice(burger.getPrice().subtract(percentage(burger.getPrice(), DISCOUNT)));
			burger.addDiscount(DISCOUNT_NAME);
		}
	}

	private BigDecimal percentage(BigDecimal base, BigDecimal pct) {
		return base.multiply(pct).scaleByPowerOfTen(-2);
	}

}
