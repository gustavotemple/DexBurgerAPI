package com.dex.burger.models.burger.strategy;

import com.dex.burger.models.burger.Burger;
import com.dex.burger.models.ingredient.IngredientInfo;
import com.dex.burger.models.ingredient.factory.IngredientFactory;

public class XBaconIngredients extends BurgerIngredientsStrategy {

	public XBaconIngredients(IngredientFactory ingredientFactory) {
		super(ingredientFactory);
	}

	@Override
	Burger addIngredients(Burger burger) {
		burger.addIngredient(ingredientFactory.create(IngredientInfo.BACON));
		burger.addIngredient(ingredientFactory.create(IngredientInfo.MEAT));
		burger.addIngredient(ingredientFactory.create(IngredientInfo.CHEESE));
		
		return burger;
	}

}
