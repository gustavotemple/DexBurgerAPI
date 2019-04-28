package com.dex.burger.models.order;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.dex.burger.models.burger.BurgerDTO;

public class OrderDTO {

	@NotEmpty(message = "Pedido sem lanches")
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
