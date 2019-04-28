package com.dexburger.menu.service;

import java.util.Collection;
import java.util.Optional;

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

@Service
public class MenuServiceImpl implements MenuService {

	private BurgerFactory burgerFactory;
	private IngredientFactory ingredientFactory;

	@Autowired
	public MenuServiceImpl(BurgerFactory burgerFactory, IngredientFactory ingredientFactory) {
		this.burgerFactory = burgerFactory;
		this.ingredientFactory = ingredientFactory;
	}

	@Override
	public Collection<Burger> getBurgers() {
		return BurgerRepository.getInstance(burgerFactory).findAll();
	}

	@Override
	public Collection<Ingredient> getIngredients() {
		return IngredientRepository.getInstance(ingredientFactory).findAll();
	}

	@Override
	public Burger getBurgerById(Long id) {
		final Optional<Burger> burger = BurgerRepository.getInstance(burgerFactory).findById(id);

		if (!burger.isPresent())
			throw new BurgerNotFoundException(id);

		return burger.get();
	}

	@Override
	public Ingredient getIngredientById(Long id) {

		final Optional<Ingredient> ingredient = IngredientRepository.getInstance(ingredientFactory)
				.findById(id);

		if (!ingredient.isPresent())
			throw new IngredientNotFoundException(id);

		return ingredient.get();
	}

}
