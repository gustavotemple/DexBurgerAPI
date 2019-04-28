package com.dex.burger.models.burger;

public enum BurgerInfo {

	XBACON(1L, new Burger(1L, "X-Bacon")),
	XBURGER(2L, new Burger(2L, "X-Burger")),
	XEGG(3L, new Burger(3L, "X-Egg")),
	XEGGBACON(4L, new Burger(4L, "X-Egg Bacon"));

	private Long id;
	private Burger burger;

	private BurgerInfo(Long id, Burger burger) {
		this.id = id;
		this.burger = burger;
	}

	public Long getId() {
		return id;
	}

	public Burger getBurger() {
		return burger;
	}

}
