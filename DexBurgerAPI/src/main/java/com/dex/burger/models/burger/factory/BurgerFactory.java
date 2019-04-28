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

		if (BurgerInfo.XBACON.equals(burgerInfo)) {
			ctx.setIngredientsStrategy(new XBaconIngredients(ingredientFactory));
			return ctx.createBurger(BurgerInfo.XBACON.getBurger());
		}

		if (BurgerInfo.XBURGER.equals(burgerInfo)) {
			ctx.setIngredientsStrategy(new XBurgerIngredients(ingredientFactory));
			return ctx.createBurger(BurgerInfo.XBURGER.getBurger());
		}

		if (BurgerInfo.XEGG.equals(burgerInfo)) {
			ctx.setIngredientsStrategy(new XEggIngredients(ingredientFactory));
			return ctx.createBurger(BurgerInfo.XEGG.getBurger());
		}

		if (BurgerInfo.XEGGBACON.equals(burgerInfo)) {
			ctx.setIngredientsStrategy(new XEggBaconIngredients(ingredientFactory));
			return ctx.createBurger(BurgerInfo.XEGGBACON.getBurger());
		}

		return null;
	}

	@Override
	public Burger create(Long id) {

		if (BurgerInfo.XBACON.getId().equals(id)) {
			return create(BurgerInfo.XBACON);
		}

		if (BurgerInfo.XBURGER.getId().equals(id)) {
			return create(BurgerInfo.XBURGER);
		}

		if (BurgerInfo.XEGG.getId().equals(id)) {
			return create(BurgerInfo.XEGG);
		}

		if (BurgerInfo.XEGGBACON.getId().equals(id)) {
			return create(BurgerInfo.XEGGBACON);
		}

		return null;
	}

}
