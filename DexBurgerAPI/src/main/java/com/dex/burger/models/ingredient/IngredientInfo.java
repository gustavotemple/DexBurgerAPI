package com.dex.burger.models.ingredient;

public enum IngredientInfo {

	LETUCE(1L, "Alface"),
	BACON(2L ,"Bacon"),
	MEAT(3L, "Hamburguer de carne"),
	EGG(4L, "Ovo"),
	CHEESE(5L, "Queijo");

	private Long id;
	private String name;

	private IngredientInfo(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public Long getId() {
		return id;
	}

}
