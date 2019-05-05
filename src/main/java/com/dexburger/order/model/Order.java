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

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Pedido")
public class Order {

	private static final AtomicLong COUNT = new AtomicLong(0L);

	@ApiModelProperty(notes = "Numero do pedido")
	private Long _id;

	@JsonIgnore
	private BigDecimal price;

	@JsonProperty("total_price")
	private String prettyPrintPrice;

	@ApiModelProperty(notes = "Lanches")
	private List<Burger> burgers = new ArrayList<>();

	public Order() {
		_id = COUNT.incrementAndGet();
	}

	public Long get_id() {
		return _id;
	}

	public void set_id(Long id) {
		if (Objects.isNull(this._id))
			this._id = id;
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
		Order other = (Order) obj;
		if (_id == null) {
			if (other._id != null)
				return false;
		} else if (!_id.equals(other._id))
			return false;
		return true;
	}

}
