package com.dex.burger.models.ingredients;

import java.math.BigDecimal;

public class Meat extends Ingredient {

	public Meat(BigDecimal price) {
		super(IngredientInfo.MEAT.getId(), IngredientInfo.MEAT.getName(), price);
	}

}
