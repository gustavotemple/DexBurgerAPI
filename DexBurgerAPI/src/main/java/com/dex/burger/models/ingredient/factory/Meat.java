package com.dex.burger.models.ingredient.factory;

import java.math.BigDecimal;

import com.dex.burger.models.ingredient.Ingredient;
import com.dex.burger.models.ingredient.IngredientInfo;

class Meat extends Ingredient {

	Meat(BigDecimal price) {
		super(IngredientInfo.MEAT.getId(), IngredientInfo.MEAT.getName(), price);
	}

}
