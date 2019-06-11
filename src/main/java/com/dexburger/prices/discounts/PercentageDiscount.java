package com.dexburger.prices.discounts;

import com.dexburger.burgers.model.Burger;

public interface PercentageDiscount {

	void apply(final Burger burger);

}
