package com.dexburger.menu.service;

import java.util.Collection;

import com.dexburger.burgers.model.Burger;
import com.dexburger.ingredients.model.Ingredient;

public interface MenuService {

	Collection<Burger> getBurgers();

	Collection<Burger> getIngredients();

	Burger getBurgerById(Long id);

	Ingredient getIngredientById(Long id);
}
