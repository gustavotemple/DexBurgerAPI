package com.dexburger.order.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import com.dexburger.burgers.model.Burger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Order {

	private static AtomicLong COUNT = new AtomicLong(0L);

	private Long id;

	@JsonIgnore
	private BigDecimal price;

	@JsonProperty("total price")
	private String prettyPrintPrice;

	private List<Burger> burgers = new ArrayList<>();

	public Order() {
		id = COUNT.incrementAndGet();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (Objects.isNull(this.id))
			this.id = id;
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

	public List<Burger> getBurgers() {
		return Optional.ofNullable(burgers).orElse(Collections.emptyList());
	}

	public void setBurgers(List<Burger> burgers) {
		this.burgers = burgers;
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
