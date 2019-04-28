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
			return IngredientInfo.LETUCE.getIngredient().setPrice(priceProperties.getLetuce());
		if (IngredientInfo.BACON.equals(ingredient))
			return IngredientInfo.BACON.getIngredient().setPrice(priceProperties.getBacon());
		if (IngredientInfo.MEAT.equals(ingredient))
			return IngredientInfo.MEAT.getIngredient().setPrice(priceProperties.getMeat());
		if (IngredientInfo.EGG.equals(ingredient))
			return IngredientInfo.EGG.getIngredient().setPrice(priceProperties.getEgg());
		if (IngredientInfo.CHEESE.equals(ingredient))
			return IngredientInfo.CHEESE.getIngredient().setPrice(priceProperties.getCheese());

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
