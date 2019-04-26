package com.dex.burger.models.ingredient;

public enum IngredientInfo {

	LETUCE(1L, "letuce"),
	BACON(2L ,"bacon"),
	MEAT(3L, "meat"),
	EGG(4L, "egg"),
	CHEESE(5L, "cheese");

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
