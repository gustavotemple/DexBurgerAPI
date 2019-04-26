package com.dex.burger.repositories;

import java.util.ArrayList;
import java.util.List;

import com.dex.burger.models.burger.Burger;
import com.dex.burger.models.burger.BurgerInfo;
import com.dex.burger.models.burger.factory.BurgerFactory;

public final class BurgerRepository {

	private static BurgerRepository instance;

	private List<Burger> burgers;

	private BurgerRepository() {
	}

	private BurgerRepository(BurgerFactory burgerFactory) {
		burgers = new ArrayList<Burger>();

		burgers.add(burgerFactory.create(BurgerInfo.XBACON));
		burgers.add(burgerFactory.create(BurgerInfo.XBURGER));
		burgers.add(burgerFactory.create(BurgerInfo.XEGG));
		burgers.add(burgerFactory.create(BurgerInfo.XEGGBACON));
	}

	public static BurgerRepository getInstance(BurgerFactory ingredientFactory) {
		if (instance == null)
			instance = new BurgerRepository(ingredientFactory);
		return instance;
	}

	public List<Burger> findAll() {
		return burgers;
	}

	public Burger findById(Long id) {
		return burgers.stream().filter(i -> id.equals(i.getId())).findAny().orElse(null);
	}

}
