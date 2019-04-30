package com.dexburger.menu.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dexburger.burgers.BurgersInfo;
import com.dexburger.burgers.factory.BurgerFactory;
import com.dexburger.burgers.model.Burger;

public final class BurgerRepository {

	private static BurgerRepository instance;

	private List<Burger> burgers;

	private BurgerRepository() {
	}

	private BurgerRepository(BurgerFactory burgerFactory) {
		burgers = new ArrayList<Burger>();

		burgers.add(burgerFactory.create(BurgersInfo.XBACON));
		burgers.add(burgerFactory.create(BurgersInfo.XBURGER));
		burgers.add(burgerFactory.create(BurgersInfo.XEGG));
		burgers.add(burgerFactory.create(BurgersInfo.XEGGBACON));
	}

	public static BurgerRepository getInstance(BurgerFactory ingredientFactory) {
		if (instance == null)
			instance = new BurgerRepository(ingredientFactory);
		return instance;
	}

	public List<Burger> findAll() {
		return burgers;
	}

	public Optional<Burger> findById(Long id) {
		return burgers.stream().filter(i -> id.equals(i.getId())).findAny();
	}

}
