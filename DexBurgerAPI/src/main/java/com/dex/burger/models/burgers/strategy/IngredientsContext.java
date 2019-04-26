package com.dex.burger.models.burgers.strategy;

import com.dex.burger.models.burgers.Burger;

public class IngredientsContext {

	private BurgerIngredientsStrategy strategy;

	public void setIngredientsStrategy(BurgerIngredientsStrategy strategy) {
		this.strategy = strategy;
	}

	public Burger createBurger(Burger burger) {
		return strategy.addIngredients(burger);
	}

}
