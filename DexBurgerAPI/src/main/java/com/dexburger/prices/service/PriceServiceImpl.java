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

	private static final int MIN_INGREDIENT_DISCOUNT = 3;
	private static final int SCALE = 2;
	private static final BigDecimal CHEESE_DISCOUNT = new BigDecimal(20);

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
	public void applyDiscount(Burger burger) {
		if (burger.getPrice() == null || burger.getPrice() == BigDecimal.ZERO
				|| CollectionUtils.isEmpty(burger.getDiscounts()))
			return;
		
		if (burger.getDiscounts().contains(Discounts.CHEESE)) {
			burger.setPrice(burger.getPrice().subtract(percentage(burger.getPrice(), CHEESE_DISCOUNT)));
			burger.setPrettyPrintPrice(formatMoney(burger.getPrice()));
		}

		// TODO

	}

	@Override
	public void fitDiscount(final Burger burger) {
		fitLightDiscount(burger);
		fitMeatDiscount(burger);
		fitCheeseDiscount(burger);
	}

	private void fitLightDiscount(final Burger burger) {
		if (burger.getIngredients().contains(IngredientsInfo.LETUCE.getIngredient())
				&& !burger.getIngredients().contains(IngredientsInfo.BACON.getIngredient()))
			burger.addDiscount(Discounts.LIGHT);
	}

	private void fitMeatDiscount(final Burger burger) {
		if (burger.getIngredients().stream().filter(IngredientsInfo.MEAT.getPredicate())
				.count() >= MIN_INGREDIENT_DISCOUNT)
			burger.addDiscount(Discounts.MEAT);
	}

	private void fitCheeseDiscount(final Burger burger) {
		if (burger.getIngredients().stream().filter(IngredientsInfo.CHEESE.getPredicate())
				.count() >= MIN_INGREDIENT_DISCOUNT)
			burger.addDiscount(Discounts.CHEESE);
	}

	private String formatMoney(BigDecimal value) {
		value.setScale(SCALE, BigDecimal.ROUND_HALF_EVEN);
		NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		return format.format(value.doubleValue());
	}
	
	private BigDecimal percentage(BigDecimal base, BigDecimal pct){
	    return base.multiply(pct).scaleByPowerOfTen(-2);
	}

}
