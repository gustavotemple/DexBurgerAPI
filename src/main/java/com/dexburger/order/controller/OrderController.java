package com.dexburger.order.controller;

import java.net.URI;
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
import org.springframework.web.util.UriComponentsBuilder;

import com.dexburger.burgers.model.Burger;
import com.dexburger.configurations.ApplicationConfig;
import com.dexburger.order.dto.OrderDTO;
import com.dexburger.order.model.Order;
import com.dexburger.order.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Pedidos")
@RequestMapping(path = ApplicationConfig.PREFIX + "/orders")
public class OrderController {

	private OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@PostMapping
	@ApiOperation(value = "Adiciona um pedido")
	public ResponseEntity<Order> addOrder(@Valid @RequestBody OrderDTO orderDTO, UriComponentsBuilder uriBuilder) {
		Order order = orderService.addOrder(orderDTO);

		URI path = uriBuilder.path(ApplicationConfig.PREFIX + "/orders/{id}").buildAndExpand(order.get_id()).toUri();

		return ResponseEntity.created(path).body(order);
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Retorna um pedido")
	public ResponseEntity<Order> getOrderById(@PathVariable("id") Long orderId) {
		return ResponseEntity.ok().body(orderService.getOrder(orderId));
	}

	@GetMapping("/{id}/burgers")
	@ApiOperation(value = "Retorna os lanches de um pedido")
	public ResponseEntity<Collection<Burger>> getBurgersByOrderId(@PathVariable("id") Long orderId) {
		return ResponseEntity.ok().body(orderService.getBurgersByOrder(orderId));
	}

	@PutMapping("/{id}")
	@ApiOperation(value = "Atualiza um pedido")
	public ResponseEntity<Order> updateOrder(@PathVariable("id") Long orderId, @Valid @RequestBody OrderDTO orderDTO) {
		return ResponseEntity.ok().body(orderService.updateOrder(orderId, orderDTO));
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Exclui um pedido")
	public ResponseEntity<Object> deleteOrder(@PathVariable("id") Long orderId) {
		orderService.deleteOrder(orderId);

		return ResponseEntity.noContent().build();
	}

	@GetMapping
	@ApiOperation(value = "Retorna todos pedidos")
	public ResponseEntity<Collection<Order>> getOrders() {
		return ResponseEntity.ok().body(orderService.findAll());
	}

}
