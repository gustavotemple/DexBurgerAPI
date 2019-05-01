package com.dexburger.burgers.strategy;

import com.dexburger.burgers.model.Burger;
import com.dexburger.ingredients.IngredientsInfo;
import com.dexburger.ingredients.factory.IngredientFactory;

public class XEggIngredients extends BurgerIngredientsStrategy {
	
	public XEggIngredients(IngredientFactory ingredientFactory) {
		super(ingredientFactory);
	}

	@Override
	Burger addIngredients(Burger burger) {
		burger.addIngredient(ingredientFactory.create(IngredientsInfo.EGG))
		.addIngredient(ingredientFactory.create(IngredientsInfo.MEAT))
		.addIngredient(ingredientFactory.create(IngredientsInfo.CHEESE));
		
		return burger;
	}

}
