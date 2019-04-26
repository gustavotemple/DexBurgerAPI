package com.dex.burger.models.burger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.dex.burger.models.ingredient.Ingredient;

public abstract class Burger {

	private Long id;
	
	private String name;

	private List<Ingredient> ingredients = new ArrayList<>();

	public Burger(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Ingredient> getIngredients() {
		return Optional.ofNullable(ingredients).orElse(Collections.emptyList());
	}

	public void addIngredient(Ingredient ingredient) {
		this.ingredients.add(ingredient);
	}

	public void removeIngredient(Ingredient ingredient) {
		this.ingredients.remove(ingredient);
	}

}
