package com.dexburger.menu.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dexburger.ingredients.IngredientsInfo;
import com.dexburger.ingredients.factory.IngredientFactory;
import com.dexburger.ingredients.model.Ingredient;

public final class IngredientRepository {

	private static IngredientRepository instance;

	private List<Ingredient> ingredients;

	private IngredientRepository() {
	}

	private IngredientRepository(IngredientFactory ingredientFactory) {
		ingredients = new ArrayList<Ingredient>();

		ingredients.add(ingredientFactory.create(IngredientsInfo.LETUCE));
		ingredients.add(ingredientFactory.create(IngredientsInfo.BACON));
		ingredients.add(ingredientFactory.create(IngredientsInfo.MEAT));
		ingredients.add(ingredientFactory.create(IngredientsInfo.EGG));
		ingredients.add(ingredientFactory.create(IngredientsInfo.CHEESE));
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
		return ingredients.stream().filter(i -> id.equals(i.get_id())).findAny();
	}

}
