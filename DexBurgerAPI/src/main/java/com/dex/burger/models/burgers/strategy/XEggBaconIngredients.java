package com.dex.burger.models.burgers.strategy;

import com.dex.burger.models.burgers.Burger;
import com.dex.burger.models.factories.IngredientFactory;
import com.dex.burger.models.ingredients.IngredientInfo;

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
