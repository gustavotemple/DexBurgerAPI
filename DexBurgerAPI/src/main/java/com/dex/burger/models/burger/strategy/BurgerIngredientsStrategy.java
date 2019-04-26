package com.dex.burger.models.burger.strategy;

import com.dex.burger.models.burger.Burger;
import com.dex.burger.models.ingredient.factory.IngredientFactory;

abstract class BurgerIngredientsStrategy {

	IngredientFactory ingredientFactory;

	BurgerIngredientsStrategy(IngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	abstract Burger addIngredients(Burger burger);

}
