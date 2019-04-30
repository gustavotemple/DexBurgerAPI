package com.dexburger.prices.service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.dexburger.burgers.model.Burger;
import com.dexburger.exceptions.BurgerNotFoundException;
import com.dexburger.exceptions.IngredientNotFoundException;
import com.dexburger.ingredients.IngredientsInfo;
import com.dexburger.ingredients.model.Ingredient;
import com.dexburger.order.model.Order;
import com.dexburger.prices.discounts.Discounts;

@Service
public class PriceServiceImpl implements PriceService {

	private static final int SCALE = 2;

	@Override
	public void calculatePrice(final Burger burger) {
		if (CollectionUtils.isEmpty(burger.getIngredients()))
			throw new IngredientNotFoundException();

		burger.setPrice(
				burger.getIngredients().stream().map(Ingredient::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add));

		burger.setPrettyPrintPrice(formatMoney(burger.getPrice()));
	}

	@Override
	public void calculatePrice(final Order order) {
		if (CollectionUtils.isEmpty(order.getBurgers()))
			throw new BurgerNotFoundException();

		order.setPrice(order.getBurgers().stream().map(Burger::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add));

		order.setPrettyPrintPrice(formatMoney(order.getPrice()));
	}

	@Override
	public void applyDiscounts(final Burger burger) {
		if (burger.getPrice() == null || burger.getPrice() == BigDecimal.ZERO)
			return;

		applyMeatCheeseDiscount(burger);
		applyLightDiscount(burger);

		burger.setPrettyPrintPrice(formatMoney(burger.getPrice()));
	}

	private void applyLightDiscount(final Burger burger) {
		if (burger.getIngredients().contains(IngredientsInfo.LETUCE.getIngredient())
				&& !burger.getIngredients().contains(IngredientsInfo.BACON.getIngredient())) {
			burger.setPrice(
					burger.getPrice().subtract(percentage(burger.getPrice(), Discounts.LIGHT.getPercentageDiscount())));
			burger.addDiscount(Discounts.LIGHT);
		}
	}

	private void applyMeatCheeseDiscount(final Burger burger) {
		int meats = 0;
		int cheeses = 0;

		for (Ingredient ingredient : burger.getIngredients()) {
			if (ingredient.getId().equals(IngredientsInfo.MEAT.getId()))
				meats++;
			else if (ingredient.getId().equals(IngredientsInfo.CHEESE.getId()))
				cheeses++;

			if (meats > 0 && meats % Discounts.MEAT.getQuantityDiscount() == 0)
				burger.setPrice(burger.getPrice().subtract(IngredientsInfo.MEAT.getIngredient().getPrice()));

			if (cheeses > 0 && cheeses % Discounts.CHEESE.getQuantityDiscount() == 0)
				burger.setPrice(burger.getPrice().subtract(IngredientsInfo.CHEESE.getIngredient().getPrice()));
		}

		if (meats >= Discounts.MEAT.getQuantityDiscount())
			burger.addDiscount(Discounts.MEAT);

		if (cheeses >= Discounts.CHEESE.getQuantityDiscount())
			burger.addDiscount(Discounts.CHEESE);
	}

	private String formatMoney(BigDecimal value) {
		value.setScale(SCALE, BigDecimal.ROUND_HALF_EVEN);
		NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		return format.format(value.doubleValue());
	}

	private BigDecimal percentage(BigDecimal base, BigDecimal pct) {
		return base.multiply(pct).scaleByPowerOfTen(-2);
	}

}
