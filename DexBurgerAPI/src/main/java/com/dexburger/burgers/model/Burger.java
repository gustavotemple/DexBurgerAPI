package com.dexburger.burgers.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.dexburger.ingredients.model.Ingredient;

public class Burger {

	private Long id;
	
	private String name;
	
	private BigDecimal price;

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
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
