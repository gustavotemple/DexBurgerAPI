package com.dex.burger.models.ingredient.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dex.burger.configuration.PriceProperties;
import com.dex.burger.models.ingredient.Ingredient;
import com.dex.burger.models.ingredient.IngredientInfo;

@Component
public class IngredientFactory implements AbstractIngredientFactory<Ingredient> {

	@Autowired
	private PriceProperties priceProperties;

	@Override
	public Ingredient create(IngredientInfo ingredient) {
		if (ingredient.equals(IngredientInfo.LETUCE))
			return new Letuce(priceProperties.getLetuce());
		if (ingredient.equals(IngredientInfo.BACON))
			return new Bacon(priceProperties.getBacon());
		if (ingredient.equals(IngredientInfo.MEAT))
			return new Meat(priceProperties.getMeat());
		if (ingredient.equals(IngredientInfo.EGG))
			return new Egg(priceProperties.getEgg());
		if (ingredient.equals(IngredientInfo.CHEESE))
			return new Cheese(priceProperties.getCheese());

		return null;
	}

}
