package com.dexburger.burgers.dto;

import java.util.List;

import javax.validation.Valid;

import com.dexburger.burgers.validator.Burger;
import com.dexburger.ingredients.dto.IngredientDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Lanche")
public class BurgerDTO {

	@Burger
	@ApiModelProperty(notes = "Numero do lanche")
	private Long _id;

	@Valid
	@ApiModelProperty(notes = "Ingredientes Extras")
	private List<IngredientDTO> extras;

	private BurgerDTO() {
	}

	public Long get_id() {
		return _id;
	}

	public void set_id(Long id) {
		this._id = id;
	}

	public List<IngredientDTO> getExtras() {
		return extras;
	}

	public void setExtras(List<IngredientDTO> extras) {
		this.extras = extras;
	}

}
