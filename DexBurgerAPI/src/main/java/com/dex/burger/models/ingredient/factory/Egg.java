package com.dex.burger.models.ingredient.factory;

import java.math.BigDecimal;

import com.dex.burger.models.ingredient.Ingredient;
import com.dex.burger.models.ingredient.IngredientInfo;

class Egg extends Ingredient {

	Egg(BigDecimal price) {
		super(IngredientInfo.EGG.getId(), IngredientInfo.EGG.getName(), price);
	}

}
