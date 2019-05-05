package com.dexburger.ingredients.dto;

import com.dexburger.ingredients.validator.IngredientExtra;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Ingrediente")
public class IngredientDTO {

	@IngredientExtra
	@ApiModelProperty(notes = "Numero do ingrediente")
	private Long _id;

	private IngredientDTO() {
	}

	public Long get_id() {
		return _id;
	}

	public void set_id(Long id) {
		this._id = id;
	}

}
