package com.dexburger.order.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dexburger.burgers.model.Burger;
import com.dexburger.order.model.Order;
import com.dexburger.order.model.OrderDTO;
import com.dexburger.order.service.OrderService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api/pedidos")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping
	@ApiOperation(value = "Adiciona um pedido")
	public ResponseEntity<Order> addOrder(@Valid @RequestBody OrderDTO orderDTO) {
		final Order order = orderService.addOrder(orderDTO);

		return ResponseEntity.ok().body(order);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um pedido")
	public ResponseEntity<Order> getOrderById(@PathVariable("id") Long orderId) {
		final Order order = orderService.getOrder(orderId);

		return ResponseEntity.ok().body(order);
	}

	@GetMapping("/{id}/lanches")
	@ApiOperation(value = "Retorna os lanches de um pedido")
	public ResponseEntity<Collection<Burger>> getBurgersByOrderId(@PathVariable("id") Long orderId) {
		return ResponseEntity.ok().body(orderService.getBurgersByOrder(orderId));
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza um pedido")
	public ResponseEntity<Order> updateOrder(@PathVariable("id") Long orderId, @Valid @RequestBody Order order) {
		final Order hospital = orderService.updateOrder(orderId, order);

		return ResponseEntity.ok().body(hospital);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Exclui um pedido")
	public ResponseEntity<String> deleteOrder(@PathVariable("id") Long orderId) {
		orderService.deleteOrder(orderId);

		return ResponseEntity.ok().body("Pedido " + orderId + " apagado.");
	}

	@GetMapping
	@ApiOperation(value = "Retorna todos pedidos")
	public ResponseEntity<Collection<Order>> getOrders() {
		return ResponseEntity.ok().body(orderService.findAll());
	}

}
