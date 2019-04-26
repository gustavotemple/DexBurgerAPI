package com.dex.burger.models.burger.strategy;

import com.dex.burger.models.burger.Burger;
import com.dex.burger.models.ingredient.IngredientInfo;
import com.dex.burger.models.ingredient.factory.IngredientFactory;

public class XEggBaconIngredients extends BurgerIngredientsStrategy {
	
	public XEggBaconIngredients(IngredientFactory ingredientFactory) {
		super(ingredientFactory);
	}

	@Override
	Burger addIngredients(Burger burger) {
		final IngredientFactory ingredientFactory = new IngredientFactory();
		
		burger.addIngredient(ingredientFactory.create(IngredientInfo.EGG));
		burger.addIngredient(ingredientFactory.create(IngredientInfo.BACON));
		burger.addIngredient(ingredientFactory.create(IngredientInfo.MEAT));
		burger.addIngredient(ingredientFactory.create(IngredientInfo.CHEESE));
		
		return burger;
	}

}
