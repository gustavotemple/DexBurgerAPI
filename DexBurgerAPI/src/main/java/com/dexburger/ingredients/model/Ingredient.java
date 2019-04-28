package com.dexburger.ingredients.model;

import java.math.BigDecimal;

public class Ingredient {

	private Long id;

	private String name;

	private BigDecimal price;

	public Ingredient(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Ingredient setPrice(BigDecimal price) {
		this.price = price;
		return this;
	}

	public BigDecimal getPrice() {
		return price;
	}

}
