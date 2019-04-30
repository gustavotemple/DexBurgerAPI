package com.dexburger.burgers.strategy;

import com.dexburger.burgers.model.Burger;
import com.dexburger.ingredients.factory.IngredientFactory;

abstract class BurgerIngredientsStrategy {

	IngredientFactory ingredientFactory;

	BurgerIngredientsStrategy(IngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	abstract Burger addIngredients(Burger burger);

}
