package com.dex.burger.models.burgers;

public enum BurgerInfo {

	XBACON(1L, "X-Bacon"),
	XBURGER(2L, "X-Burger"),
	XEGG(3L, "X-Egg"),
	XEGGBACON(4L, "X-Egg Bacon");

	private Long id;
	private String name;

	private BurgerInfo(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

}
