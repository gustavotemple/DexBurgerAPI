package com.dexburger.prices.service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.dexburger.burgers.model.Burger;
import com.dexburger.exceptions.BurgerNotFoundException;
import com.dexburger.exceptions.IngredientNotFoundException;
import com.dexburger.ingredients.model.Ingredient;
import com.dexburger.order.model.Order;
import com.dexburger.prices.discounts.PercentageDiscount;
import com.dexburger.prices.discounts.QuantityDiscount;

@Service
public class PriceServiceImpl implements PriceService {

	private static final int SCALE = 2;

	private final List<QuantityDiscount> quantityDiscounts;
	private final List<PercentageDiscount> percentageDiscounts;

	@Autowired
	public PriceServiceImpl(final List<QuantityDiscount> quantityDiscounts,
			final List<PercentageDiscount> percentageDiscounts) {
		this.quantityDiscounts = quantityDiscounts;
		this.percentageDiscounts = percentageDiscounts;
	}

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

		quantityDiscounts.forEach(discount -> discount.apply(burger));
		percentageDiscounts.forEach(discount -> discount.apply(burger));

		burger.setPrettyPrintPrice(formatMoney(burger.getPrice()));
	}

	private String formatMoney(BigDecimal value) {
		value.setScale(SCALE, BigDecimal.ROUND_HALF_EVEN);
		NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		return format.format(value.doubleValue());
	}

}
