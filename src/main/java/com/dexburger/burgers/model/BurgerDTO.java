package com.dexburger.burgers.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Lanche")
public class BurgerDTO {

	@ApiModelProperty(notes = "Numero do lanche")
	private Long _id;

	@ApiModelProperty(notes = "Ingredientes Extras")
	private List<Long> extras;

	private BurgerDTO() {
	}

	public Long get_id() {
		return _id;
	}

	public void set_id(Long id) {
		this._id = id;
	}

	public List<Long> getExtras() {
		return extras;
	}

	public void setExtras(List<Long> extras) {
		this.extras = extras;
	}

}
