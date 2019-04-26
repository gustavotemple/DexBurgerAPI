package com.dex.burger.configuration;

import java.math.BigDecimal;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "dexburger.price")
public class PriceProperties {

	private BigDecimal letuce;
	private BigDecimal bacon;
	private BigDecimal meat;
	private BigDecimal egg;
	private BigDecimal cheese;

	private PriceProperties() {
	}

	public BigDecimal getLetuce() {
		return letuce;
	}

	public void setLetuce(BigDecimal letuce) {
		this.letuce = letuce;
	}

	public BigDecimal getBacon() {
		return bacon;
	}

	public void setBacon(BigDecimal bacon) {
		this.bacon = bacon;
	}

	public BigDecimal getMeat() {
		return meat;
	}

	public void setMeat(BigDecimal meat) {
		this.meat = meat;
	}

	public BigDecimal getEgg() {
		return egg;
	}

	public void setEgg(BigDecimal egg) {
		this.egg = egg;
	}

	public BigDecimal getCheese() {
		return cheese;
	}

	public void setCheese(BigDecimal cheese) {
		this.cheese = cheese;
	}

}
