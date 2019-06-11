package com.dexburger.menu.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dexburger.burgers.model.Burger;
import com.dexburger.configurations.ApplicationConfig;
import com.dexburger.ingredients.model.Ingredient;
import com.dexburger.menu.service.MenuService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Cardapio")
@RequestMapping(path = ApplicationConfig.PREFIX)
public class MenuController {

	private MenuService menuService;

	@Autowired
	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}

	@Cacheable(value="burgers")
	@GetMapping("/burgers")
	@ApiOperation(value = "Retorna todos lanches do menu")
	public Collection<Burger> getBurgers() {
		return menuService.getBurgers();
	}

	@Cacheable(value="burgers", key="#id")
	@GetMapping("/burgers/{id}")
	@ApiOperation(value = "Retorna um lanche do menu")
	public Burger getBurgerById(@PathVariable("id") Long burgerId) {
		return menuService.getBurgerById(burgerId);
	}

	@Cacheable(value="ingredients")
	@GetMapping("/ingredients")
	@ApiOperation(value = "Retorna todos ingredientes do menu")
	public Collection<Ingredient> getIngredients() {
		return menuService.getIngredients();
	}

	@Cacheable(value="ingredients", key="#id")
	@GetMapping("/ingredients/{id}")
	@ApiOperation(value = "Retorna um ingrediente do menu")
	public Ingredient getIngredientById(@PathVariable("id") Long ingredientId) {
		return menuService.getIngredientById(ingredientId);
	}

}
