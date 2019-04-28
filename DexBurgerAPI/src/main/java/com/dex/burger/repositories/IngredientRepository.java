package com.dex.burger.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dex.burger.models.ingredient.Ingredient;
import com.dex.burger.models.ingredient.IngredientInfo;
import com.dex.burger.models.ingredient.factory.IngredientFactory;

public final class IngredientRepository {

	private static IngredientRepository instance;

	private List<Ingredient> ingredients;

	private IngredientRepository() {
	}

	private IngredientRepository(IngredientFactory ingredientFactory) {
		ingredients = new ArrayList<Ingredient>();

		ingredients.add(ingredientFactory.create(IngredientInfo.LETUCE));
		ingredients.add(ingredientFactory.create(IngredientInfo.BACON));
		ingredients.add(ingredientFactory.create(IngredientInfo.MEAT));
		ingredients.add(ingredientFactory.create(IngredientInfo.EGG));
		ingredients.add(ingredientFactory.create(IngredientInfo.CHEESE));
	}

	public static IngredientRepository getInstance(IngredientFactory ingredientFactory) {
		if (instance == null)
			instance = new IngredientRepository(ingredientFactory);
		return instance;
	}

	public List<Ingredient> findAll() {
		return ingredients;
	}

	public Optional<Ingredient> findById(Long id) {
		return ingredients.stream().filter(i -> id.equals(i.getId())).findAny();
	}

}
