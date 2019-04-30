package com.dexburger.burgers.strategy;

import com.dexburger.burgers.model.Burger;

public class IngredientsContext {

	private BurgerIngredientsStrategy strategy;

	public void setIngredientsStrategy(BurgerIngredientsStrategy strategy) {
		this.strategy = strategy;
	}

	public Burger createBurger(Burger burger) {
		return strategy.addIngredients(burger);
	}

}
