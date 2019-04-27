package com.dex.burger.models.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import com.dex.burger.models.burger.Burger;

public class Order {

	private static AtomicLong i = new AtomicLong(0L);

	private Long id;

	private BigDecimal price;

	private List<OrderDiscount> discounts = new ArrayList<>();

	private List<Burger> burgers = new ArrayList<>();

	public Order() {
		id = i.incrementAndGet();
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

	public List<Burger> getBurgers() {
		return Optional.ofNullable(burgers).orElse(Collections.emptyList());
	}

	public void setBurgers(List<Burger> burgers) {
		this.burgers = burgers;
	}

	public List<OrderDiscount> getDiscounts() {
		return Optional.ofNullable(discounts).orElse(Collections.emptyList());
	}

	public void addDiscount(OrderDiscount discount) {
		this.discounts.add(discount);
	}

	public void removeDiscount(OrderDiscount discount) {
		this.discounts.remove(discount);
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
