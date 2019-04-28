package com.dexburger.menu.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dexburger.burgers.model.Burger;
import com.dexburger.ingredients.model.Ingredient;
import com.dexburger.menu.service.MenuService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api")
public class MenuController {

	private MenuService menuService;

	@Autowired
	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}

	@GetMapping("/lanches")
	@ApiOperation(value = "Retorna todos lanches do menu")
	public ResponseEntity<Collection<Burger>> getBurgers() {
		return ResponseEntity.ok().body(menuService.getBurgers());
	}

	@GetMapping("/lanches/{id}")
	@ApiOperation(value = "Retorna um lanche do menu")
	public ResponseEntity<Burger> getBurgerById(@PathVariable("id") Long burgerId) {
		return ResponseEntity.ok().body(menuService.getBurgerById(burgerId));
	}

	@GetMapping("/ingredientes")
	@ApiOperation(value = "Retorna todos ingredientes do menu")
	public ResponseEntity<Collection<Ingredient>> getIngredients() {
		return ResponseEntity.ok().body(menuService.getIngredients());
	}

	@GetMapping("/ingredientes/{id}")
	@ApiOperation(value = "Retorna um ingrediente do menu")
	public ResponseEntity<Ingredient> getIngredientById(@PathVariable("id") Long ingredientId) {
		return ResponseEntity.ok().body(menuService.getIngredientById(ingredientId));
	}

}
