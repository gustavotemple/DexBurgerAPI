package com.dex.burger.models.ingredient.factory;

import java.math.BigDecimal;

import com.dex.burger.models.ingredient.Ingredient;
import com.dex.burger.models.ingredient.IngredientInfo;

class Bacon extends Ingredient {

	Bacon(BigDecimal price) {
		super(IngredientInfo.BACON.getId(), IngredientInfo.BACON.getName(), price);
	}

}
