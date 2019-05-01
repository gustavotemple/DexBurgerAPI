package com.dexburger.ingredients.model;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Ingrediente")
public class Ingredient {

	@ApiModelProperty(notes = "Numero do ingrediente")
	private Long _id;

	@ApiModelProperty(notes = "Nome")
	private String name;

	@ApiModelProperty(notes = "Preco")
	private BigDecimal price;

	public Ingredient(Long id, String name) {
		this._id = id;
		this.name = name;
	}

	public Long get_id() {
		return _id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
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
		Ingredient other = (Ingredient) obj;
		if (_id == null) {
			if (other._id != null)
				return false;
		} else if (!_id.equals(other._id))
			return false;
		return true;
	}

}
