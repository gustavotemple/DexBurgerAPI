package com.dex.burger.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dex.burger.models.burgers.Burger;
import com.dex.burger.models.burgers.BurgerInfo;
import com.dex.burger.models.factories.BurgerFactory;
import com.dex.burger.models.factories.IngredientFactory;
import com.dex.burger.models.ingredients.IngredientInfo;
import com.dex.burger.models.order.Order;

@RestController
@RequestMapping(path = "/api/pedidos")
public class OrderController {

	@Autowired
	IngredientFactory ingredientFactory;

	@Autowired
	BurgerFactory burgerFactory;

	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable("id") Long orderId) {
		final Order order = new Order();

		Burger b = burgerFactory.create(BurgerInfo.XBACON);

		b.addIngredient(ingredientFactory.create(IngredientInfo.CHEESE));
		b.addIngredient(ingredientFactory.create(IngredientInfo.CHEESE));

		order.addBurger(b);

		return ResponseEntity.ok().body(order);
	}

}
