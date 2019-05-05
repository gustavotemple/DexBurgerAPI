package com.dexburger.menu.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dexburger.burgers.factory.BurgerFactory;
import com.dexburger.burgers.model.Burger;
import com.dexburger.exceptions.BurgerNotFoundException;
import com.dexburger.exceptions.IngredientNotFoundException;
import com.dexburger.ingredients.factory.IngredientFactory;
import com.dexburger.ingredients.model.Ingredient;
import com.dexburger.menu.repositories.BurgerRepository;
import com.dexburger.menu.repositories.IngredientRepository;
import com.dexburger.prices.service.PriceService;

@Service
public class MenuServiceImpl implements MenuService {

	private PriceService priceService;
	private BurgerFactory burgerFactory;
	private IngredientFactory ingredientFactory;

	@Autowired
	public MenuServiceImpl(BurgerFactory burgerFactory, IngredientFactory ingredientFactory,
			PriceService priceService) {
		this.burgerFactory = burgerFactory;
		this.ingredientFactory = ingredientFactory;
		this.priceService = priceService;
	}

	@Override
	public Collection<Burger> getBurgers() {
		List<Burger> burgers = BurgerRepository.getInstance(burgerFactory).findAll();

		burgers.stream().forEach(burger -> priceService.calculatePrice(burger));

		return burgers;
	}

	@Override
	public Collection<Ingredient> getIngredients() {
		return IngredientRepository.getInstance(ingredientFactory).findAll();
	}

	@Override
	public Burger getBurgerById(Long id) {
		Burger burger = BurgerRepository.getInstance(burgerFactory).findById(id)
				.orElseThrow(() -> new BurgerNotFoundException(id));

		priceService.calculatePrice(burger);

		return burger;
	}

	@Override
	public Ingredient getIngredientById(Long id) {
		return IngredientRepository.getInstance(ingredientFactory).findById(id)
				.orElseThrow(() -> new IngredientNotFoundException(id));
	}

}
