package com.dex.burger.models.ingredients;

import java.math.BigDecimal;

public class Egg extends Ingredient {

	public Egg(BigDecimal price) {
		super(IngredientInfo.EGG.getId(), IngredientInfo.EGG.getName(), price);
	}

}
