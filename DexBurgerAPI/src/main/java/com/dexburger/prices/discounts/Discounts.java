package com.dexburger.prices.discounts;

import java.math.BigDecimal;

public enum Discounts {
	LIGHT(0, new BigDecimal(10)),
	MEAT(3, new BigDecimal(0)),
	CHEESE(3, new BigDecimal(0));

	private int quantityDiscount;
	private BigDecimal percentageDiscount;

	private Discounts(int quantityDiscount, BigDecimal percentageDiscount) {
		this.quantityDiscount = quantityDiscount;
		this.percentageDiscount = percentageDiscount;
	}

	public int getQuantityDiscount() {
		return quantityDiscount;
	}

	public BigDecimal getPercentageDiscount() {
		return percentageDiscount;
	}

}
