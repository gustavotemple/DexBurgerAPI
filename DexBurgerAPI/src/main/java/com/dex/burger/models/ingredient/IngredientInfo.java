package com.dex.burger.models.ingredient;

public enum IngredientInfo {

	LETUCE(1L, new Ingredient(1L, "Alface")),
	BACON(2L, new Ingredient(2L, "Bacon")),
	MEAT(3L, new Ingredient(3L, "Hamburguer de carne")),
	EGG(4L, new Ingredient(4L, "Ovo")),
	CHEESE(5L, new Ingredient(5L, "Queijo"));

	private Long id;
	private Ingredient ingredient;

	private IngredientInfo(Long id, Ingredient ingredient) {
		this.id = id;
		this.ingredient = ingredient;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public Long getId() {
		return id;
	}

}
