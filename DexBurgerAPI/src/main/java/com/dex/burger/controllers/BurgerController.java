package com.dex.burger.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dex.burger.models.burger.Burger;
import com.dex.burger.models.burger.factory.BurgerFactory;
import com.dex.burger.repositories.BurgerRepository;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api/lanches")
public class BurgerController {

	@Autowired
	private BurgerFactory burgerFactory;

	@GetMapping
	@ApiOperation(value = "Retorna todos lanches")
	public ResponseEntity<Collection<Burger>> getBurgers() {
		return ResponseEntity.ok().body(BurgerRepository.getInstance(burgerFactory).findAll());
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um lanche")
	public ResponseEntity<Burger> getBurgerById(@PathVariable("id") Long burgerId) {
		final Burger burger = BurgerRepository.getInstance(burgerFactory).findById(burgerId);

		return ResponseEntity.ok().body(burger);
	}

}
