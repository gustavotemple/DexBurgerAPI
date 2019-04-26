package com.dex.burger.models.ingredient.factory;

import java.math.BigDecimal;

import com.dex.burger.models.ingredient.Ingredient;
import com.dex.burger.models.ingredient.IngredientInfo;

class Letuce extends Ingredient {

	Letuce(BigDecimal price) {
		super(IngredientInfo.LETUCE.getId(), IngredientInfo.LETUCE.getName(), price);
	}

}
