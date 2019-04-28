package com.dexburger.ingredients.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dexburger.configuration.PriceProperties;
import com.dexburger.ingredients.IngredientsInfo;
import com.dexburger.ingredients.model.Ingredient;

@Component
public class IngredientFactory implements AbstractIngredientFactory<Ingredient> {

	@Autowired
	private PriceProperties priceProperties;

	@Override
	public Ingredient create(IngredientsInfo ingredient) {
		if (IngredientsInfo.LETUCE.equals(ingredient))
			return IngredientsInfo.LETUCE.getIngredient().setPrice(priceProperties.getLetuce());
		if (IngredientsInfo.BACON.equals(ingredient))
			return IngredientsInfo.BACON.getIngredient().setPrice(priceProperties.getBacon());
		if (IngredientsInfo.MEAT.equals(ingredient))
			return IngredientsInfo.MEAT.getIngredient().setPrice(priceProperties.getMeat());
		if (IngredientsInfo.EGG.equals(ingredient))
			return IngredientsInfo.EGG.getIngredient().setPrice(priceProperties.getEgg());
		if (IngredientsInfo.CHEESE.equals(ingredient))
			return IngredientsInfo.CHEESE.getIngredient().setPrice(priceProperties.getCheese());

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
