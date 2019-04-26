package com.dex.burger.models.order;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.dex.burger.models.burger.Burger;

public class Order {

	private Long id;

	private List<Burger> burgers = new ArrayList<>();

	public Order() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (Objects.isNull(this.id))
			this.id = id;
	}

	public List<Burger> getBurgers() {
		return Optional.ofNullable(burgers).orElse(Collections.emptyList());
	}

	public void addBurger(Burger burger) {
		this.burgers.add(burger);
	}

	public void removeBurger(Burger burger) {
		this.burgers.remove(burger);
	}

}
