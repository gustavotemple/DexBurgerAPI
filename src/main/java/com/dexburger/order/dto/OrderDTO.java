package com.dexburger.order.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.dexburger.burgers.dto.BurgerDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Pedido")
public class OrderDTO {

	@Valid
	@NotNull(message = "{burgers.notnull}")
	@Size(min = 1, message = "{burgers.size}")
	@ApiModelProperty(notes = "Lanches")
	private List<BurgerDTO> burgers;

	private OrderDTO() {
	}

	public List<BurgerDTO> getBurgers() {
		return burgers;
	}

	public void setBurgers(List<BurgerDTO> burgers) {
		this.burgers = burgers;
	}

}
