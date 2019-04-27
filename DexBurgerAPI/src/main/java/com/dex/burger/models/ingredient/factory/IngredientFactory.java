package com.dex.burger.models.ingredient.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dex.burger.configuration.PriceProperties;
import com.dex.burger.models.ingredient.Ingredient;
import com.dex.burger.models.ingredient.IngredientInfo;

@Component
public class IngredientFactory implements AbstractIngredientFactory<Ingredient> {

	@Autowired
	private PriceProperties priceProperties;

	@Override
	public Ingredient create(IngredientInfo ingredient) {
		if (IngredientInfo.LETUCE.equals(ingredient))
			return new Letuce(priceProperties.getLetuce());
		if (IngredientInfo.BACON.equals(ingredient))
			return new Bacon(priceProperties.getBacon());
		if (IngredientInfo.MEAT.equals(ingredient))
			return new Meat(priceProperties.getMeat());
		if (IngredientInfo.EGG.equals(ingredient))
			return new Egg(priceProperties.getEgg());
		if (IngredientInfo.CHEESE.equals(ingredient))
			return new Cheese(priceProperties.getCheese());

		return null;
	}

	@Override
	public Ingredient create(Long id) {
		if (IngredientInfo.LETUCE.getId().equals(id))
			return create(IngredientInfo.LETUCE);
		if (IngredientInfo.BACON.getId().equals(id))
			return create(IngredientInfo.BACON);
		if (IngredientInfo.MEAT.getId().equals(id))
			return create(IngredientInfo.MEAT);
		if (IngredientInfo.EGG.getId().equals(id))
			return create(IngredientInfo.EGG);
		if (IngredientInfo.CHEESE.getId().equals(id))
			return create(IngredientInfo.CHEESE);

		return null;
	}

}
