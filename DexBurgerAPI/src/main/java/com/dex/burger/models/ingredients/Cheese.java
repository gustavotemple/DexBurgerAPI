package com.dex.burger.models.ingredients;

import java.math.BigDecimal;

public class Cheese extends Ingredient {

	public Cheese(BigDecimal price) {
		super(IngredientInfo.CHEESE.getId(), IngredientInfo.CHEESE.getName(), price);
	}

}
