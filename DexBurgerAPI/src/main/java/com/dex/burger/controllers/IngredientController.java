package com.dex.burger.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dex.burger.models.ingredient.Ingredient;
import com.dex.burger.models.ingredient.factory.IngredientFactory;
import com.dex.burger.repositories.IngredientRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api/ingredientes")
public class IngredientController {

	@Autowired
	private IngredientFactory ingredientFactory;

	@GetMapping
	@ApiOperation(value = "Retorna todos ingredientes")
	public ResponseEntity<Collection<Ingredient>> getIngredients() {
		return ResponseEntity.ok().body(IngredientRepository.getInstance(ingredientFactory).findAll());
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um ingrediente")
	public ResponseEntity<Ingredient> getIngredientById(@PathVariable("id") Long ingredientId) {
		final Ingredient ingredient = IngredientRepository.getInstance(ingredientFactory).findById(ingredientId);

		return ResponseEntity.ok().body(ingredient);
	}

}
