package com.dex.burger.models.burgers.strategy;

import com.dex.burger.models.burgers.Burger;
import com.dex.burger.models.factories.IngredientFactory;

abstract class BurgerIngredientsStrategy {

	IngredientFactory ingredientFactory;

	BurgerIngredientsStrategy(IngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	abstract Burger addIngredients(Burger burger);

}
