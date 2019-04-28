package com.dex.burger.models.burger;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class BurgerDTO {

	@ApiModelProperty(notes = "Numero do lanche")
	private Long id;

	@ApiModelProperty(notes = "Ingredientes Extras")
	private List<Long> extras;

	private BurgerDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Long> getExtras() {
		return extras;
	}

	public void setExtras(List<Long> extras) {
		this.extras = extras;
	}

}
