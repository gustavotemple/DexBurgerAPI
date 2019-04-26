package com.dex.burger.models.ingredients;

import java.math.BigDecimal;

public class Letuce extends Ingredient {

	public Letuce(BigDecimal price) {
		super(IngredientInfo.LETUCE.getId(), IngredientInfo.LETUCE.getName(), price);
	}

}
