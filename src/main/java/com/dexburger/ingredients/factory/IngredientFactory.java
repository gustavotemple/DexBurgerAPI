package com.dexburger.ingredients.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dexburger.ingredients.IngredientsInfo;
import com.dexburger.ingredients.model.Ingredient;
import com.dexburger.prices.IngredientsPrices;

@Component
public class IngredientFactory implements AbstractIngredientFactory<Ingredient> {

	private IngredientsPrices ingredientsPrices;

	@Autowired
	public IngredientFactory(IngredientsPrices ingredientsPrices) {
		this.ingredientsPrices = ingredientsPrices;
	}

	@Override
	public Ingredient create(IngredientsInfo ingredient) {
		if (IngredientsInfo.LETUCE.equals(ingredient))
			return IngredientsInfo.LETUCE.getIngredient().setPrice(ingredientsPrices.getLetuce());
		if (IngredientsInfo.BACON.equals(ingredient))
			return IngredientsInfo.BACON.getIngredient().setPrice(ingredientsPrices.getBacon());
		if (IngredientsInfo.MEAT.equals(ingredient))
			return IngredientsInfo.MEAT.getIngredient().setPrice(ingredientsPrices.getMeat());
		if (IngredientsInfo.EGG.equals(ingredient))
			return IngredientsInfo.EGG.getIngredient().setPrice(ingredientsPrices.getEgg());
		if (IngredientsInfo.CHEESE.equals(ingredient))
			return IngredientsInfo.CHEESE.getIngredient().setPrice(ingredientsPrices.getCheese());

		return null;
	}

	@Override
	public Ingredient create(Long id) {
		if (IngredientsInfo.LETUCE.getId().equals(id))
			return create(IngredientsInfo.LETUCE);
		if (IngredientsInfo.BACON.getId().equals(id))
			return create(IngredientsInfo.BACON);
		if (IngredientsInfo.MEAT.getId().equals(id))
			return create(IngredientsInfo.MEAT);
		if (IngredientsInfo.EGG.getId().equals(id))
			return create(IngredientsInfo.EGG);
		if (IngredientsInfo.CHEESE.getId().equals(id))
			return create(IngredientsInfo.CHEESE);

		return null;
	}

}
