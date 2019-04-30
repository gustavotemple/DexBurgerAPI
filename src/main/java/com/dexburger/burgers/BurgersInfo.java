package com.dexburger.burgers;

public enum BurgersInfo {

	XBACON(1L, "X-Bacon"),
	XBURGER(2L, "X-Burger"),
	XEGG(3L, "X-Egg"),
	XEGGBACON(4L, "X-Egg Bacon");

	private Long id;
	private String name;

	private BurgersInfo(Long id, String burger) {
		this.id = id;
		this.name = burger;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
