package com.dex.burger.models.ingredients;

import java.math.BigDecimal;

public abstract class Ingredient {

	private Long id;

	private String name;

	private BigDecimal price;

	public Ingredient(Long id, String name, BigDecimal price) {
		this.id = id;
		this.name = name;
		this.price = price;
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

}
