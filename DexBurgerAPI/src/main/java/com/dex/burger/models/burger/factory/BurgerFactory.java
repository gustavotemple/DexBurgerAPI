package com.dex.burger.models.burger.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dex.burger.models.burger.Burger;
import com.dex.burger.models.burger.BurgerInfo;
import com.dex.burger.models.burger.strategy.IngredientsContext;
import com.dex.burger.models.burger.strategy.XBaconIngredients;
import com.dex.burger.models.burger.strategy.XBurgerIngredients;
import com.dex.burger.models.burger.strategy.XEggBaconIngredients;
import com.dex.burger.models.burger.strategy.XEggIngredients;
import com.dex.burger.models.ingredient.factory.IngredientFactory;

@Component
public class BurgerFactory implements AbstracBurgerFactory<Burger> {
	
	@Autowired
	IngredientFactory ingredientFactory;

	@Override
	public Burger create(BurgerInfo burgerInfo) {

		final IngredientsContext ctx = new IngredientsContext();

		if (burgerInfo.equals(BurgerInfo.XBACON)) {
			ctx.setIngredientsStrategy(new XBaconIngredients(ingredientFactory));
			return ctx.createBurger(new XBacon());
		}

		if (burgerInfo.equals(BurgerInfo.XBURGER)) {
			ctx.setIngredientsStrategy(new XBurgerIngredients(ingredientFactory));
			return ctx.createBurger(new XBurger());
		}

		if (burgerInfo.equals(BurgerInfo.XEGG)) {
			ctx.setIngredientsStrategy(new XEggIngredients(ingredientFactory));
			return ctx.createBurger(new XEgg());
		}

		if (burgerInfo.equals(BurgerInfo.XEGGBACON)) {
			ctx.setIngredientsStrategy(new XEggBaconIngredients(ingredientFactory));
			return ctx.createBurger(new XEggBacon());
		}

		return null;
	}

}
