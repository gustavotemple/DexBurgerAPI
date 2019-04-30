package com.dexburger.order.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.dexburger.burgers.model.BurgerDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Pedido")
public class OrderDTO {

	@NotEmpty(message = "Pedido sem lanches")
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
