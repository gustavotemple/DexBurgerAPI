package com.dexburger.burgers.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dexburger.burgers.BurgersInfo;
import com.dexburger.burgers.model.Burger;
import com.dexburger.burgers.strategy.IngredientsContext;
import com.dexburger.burgers.strategy.XBaconIngredients;
import com.dexburger.burgers.strategy.XBurgerIngredients;
import com.dexburger.burgers.strategy.XEggBaconIngredients;
import com.dexburger.burgers.strategy.XEggIngredients;
import com.dexburger.ingredients.factory.IngredientFactory;

@Component
public class BurgerFactory implements AbstracBurgerFactory<Burger> {

	@Autowired
	private IngredientFactory ingredientFactory;

	@Override
	public Burger create(BurgersInfo burgerInfo) {

		final IngredientsContext ctx = new IngredientsContext();

		if (BurgersInfo.XBACON.equals(burgerInfo)) {
			ctx.setIngredientsStrategy(new XBaconIngredients(ingredientFactory));
			return ctx.createBurger(new XBacon());
		}

		if (BurgersInfo.XBURGER.equals(burgerInfo)) {
			ctx.setIngredientsStrategy(new XBurgerIngredients(ingredientFactory));
			return ctx.createBurger(new XBurger());
		}

		if (BurgersInfo.XEGG.equals(burgerInfo)) {
			ctx.setIngredientsStrategy(new XEggIngredients(ingredientFactory));
			return ctx.createBurger(new XEgg());
		}

		if (BurgersInfo.XEGGBACON.equals(burgerInfo)) {
			ctx.setIngredientsStrategy(new XEggBaconIngredients(ingredientFactory));
			return ctx.createBurger(new XEggBacon());
		}

		return null;
	}

	@Override
	public Burger create(Long id) {

		if (BurgersInfo.XBACON.getId().equals(id)) {
			return create(BurgersInfo.XBACON);
		}

		if (BurgersInfo.XBURGER.getId().equals(id)) {
			return create(BurgersInfo.XBURGER);
		}

		if (BurgersInfo.XEGG.getId().equals(id)) {
			return create(BurgersInfo.XEGG);
		}

		if (BurgersInfo.XEGGBACON.getId().equals(id)) {
			return create(BurgersInfo.XEGGBACON);
		}

		return null;
	}

}
