package com.dex.burger.models.burgers.strategy;

import com.dex.burger.models.burgers.Burger;
import com.dex.burger.models.factories.IngredientFactory;
import com.dex.burger.models.ingredients.IngredientInfo;

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
