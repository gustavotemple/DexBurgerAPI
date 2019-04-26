package com.dex.burger.models.ingredients;

import java.math.BigDecimal;

public class Bacon extends Ingredient {

	public Bacon(BigDecimal price) {
		super(IngredientInfo.BACON.getId(), IngredientInfo.BACON.getName(), price);
	}

}
