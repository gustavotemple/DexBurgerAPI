package com.dex.burger.models.ingredient.factory;

import java.math.BigDecimal;

import com.dex.burger.models.ingredient.Ingredient;
import com.dex.burger.models.ingredient.IngredientInfo;

class Cheese extends Ingredient {

	Cheese(BigDecimal price) {
		super(IngredientInfo.CHEESE.getId(), IngredientInfo.CHEESE.getName(), price);
	}

}
