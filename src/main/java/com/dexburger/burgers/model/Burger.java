package com.dexburger.burgers.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.dexburger.ingredients.model.Ingredient;
import com.dexburger.prices.discounts.Discounts;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class Burger {

	private Long id;

	private String name;

	@JsonIgnore
	private BigDecimal price;

	@JsonProperty("price")
	private String prettyPrintPrice;

	private List<Ingredient> ingredients;

	private List<Discounts> discounts;

	public Burger(Long id, String name) {
		this.id = id;
		this.name = name;
		this.ingredients = new ArrayList<>();
		this.discounts = new ArrayList<>();
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

	public String getPrettyPrintPrice() {
		return prettyPrintPrice;
	}

	public void setPrettyPrintPrice(String prettyPrintPrice) {
		this.prettyPrintPrice = prettyPrintPrice;
	}

	public List<Discounts> getDiscounts() {
		return Optional.ofNullable(discounts).orElse(Collections.emptyList());
	}

	public void addDiscount(Discounts discount) {
		this.discounts.add(discount);
	}

	public void removeDiscount(Discounts discount) {
		this.discounts.remove(discount);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Burger other = (Burger) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
