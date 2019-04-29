package com.dexburger.ingredients;

import java.util.function.Predicate;

import com.dexburger.ingredients.model.Ingredient;

public enum IngredientsInfo {

	LETUCE(1L, new Ingredient(1L, "Alface"), (i -> i.getId().equals(1L))),
	BACON(2L, new Ingredient(2L, "Bacon"), (i -> i.getId().equals(2L))),
	MEAT(3L, new Ingredient(3L, "Hamburguer de carne"), (i -> i.getId().equals(3L))),
	EGG(4L, new Ingredient(4L, "Ovo"), (i -> i.getId().equals(4L))),
	CHEESE(5L, new Ingredient(5L, "Queijo"), (i -> i.getId().equals(5L)));

	private Long id;
	private Ingredient ingredient;
	private Predicate<Ingredient> predicate;

	private IngredientsInfo(Long id, Ingredient ingredient, Predicate<Ingredient> predicate) {
		this.id = id;
		this.ingredient = ingredient;
		this.predicate = predicate;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public Long getId() {
		return id;
	}

	public Predicate<Ingredient> getPredicate() {
		return predicate;
	}

}
