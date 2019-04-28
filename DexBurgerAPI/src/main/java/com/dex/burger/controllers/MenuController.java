package com.dex.burger.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dex.burger.exceptions.BurgerNotFoundException;
import com.dex.burger.exceptions.IngredientNotFoundException;
import com.dex.burger.models.burger.Burger;
import com.dex.burger.models.burger.factory.BurgerFactory;
import com.dex.burger.models.ingredient.Ingredient;
import com.dex.burger.models.ingredient.factory.IngredientFactory;
import com.dex.burger.repositories.BurgerRepository;
import com.dex.burger.repositories.IngredientRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api")
public class MenuController {

	@Autowired
	private BurgerFactory burgerFactory;

	@Autowired
	private IngredientFactory ingredientFactory;

	@GetMapping("/lanches")
	@ApiOperation(value = "Retorna todos lanches")
	public ResponseEntity<Collection<Burger>> getBurgers() {
		return ResponseEntity.ok().body(BurgerRepository.getInstance(burgerFactory).findAll());
	}

	@GetMapping("/lanches/{id}")
	@ApiOperation(value = "Retorna um lanche")
	public ResponseEntity<Burger> getBurgerById(@PathVariable("id") Long burgerId) {
		final Optional<Burger> burger = BurgerRepository.getInstance(burgerFactory).findById(burgerId);

		if (!burger.isPresent())
			throw new BurgerNotFoundException(burgerId);

		return ResponseEntity.ok().body(burger.get());
	}

	@GetMapping("/ingredientes")
	@ApiOperation(value = "Retorna todos ingredientes")
	public ResponseEntity<Collection<Ingredient>> getIngredients() {
		return ResponseEntity.ok().body(IngredientRepository.getInstance(ingredientFactory).findAll());
	}

	@GetMapping("/ingredientes/{id}")
	@ApiOperation(value = "Retorna um ingrediente")
	public ResponseEntity<Ingredient> getIngredientById(@PathVariable("id") Long ingredientId) {
		final Optional<Ingredient> ingredient = IngredientRepository.getInstance(ingredientFactory)
				.findById(ingredientId);

		if (!ingredient.isPresent())
			throw new IngredientNotFoundException(ingredientId);

		return ResponseEntity.ok().body(ingredient.get());
	}

}
