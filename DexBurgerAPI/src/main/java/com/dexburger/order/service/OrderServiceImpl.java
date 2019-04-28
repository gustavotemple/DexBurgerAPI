package com.dexburger.order.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.dexburger.burgers.factory.BurgerFactory;
import com.dexburger.burgers.model.Burger;
import com.dexburger.burgers.model.BurgerDTO;
import com.dexburger.exceptions.BurgerNotFoundException;
import com.dexburger.exceptions.OrderNotFoundException;
import com.dexburger.ingredients.factory.IngredientFactory;
import com.dexburger.ingredients.model.Ingredient;
import com.dexburger.order.model.Order;
import com.dexburger.order.model.OrderDTO;
import com.dexburger.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	private BurgerFactory burgerFactory;
	private IngredientFactory ingredientFactory;
	private OrderRepository orderRepository;
	
	@Autowired
	public OrderServiceImpl(BurgerFactory burgerFactory, IngredientFactory ingredientFactory,
			OrderRepository orderRepository) {
		this.burgerFactory = burgerFactory;
		this.ingredientFactory = ingredientFactory;
		this.orderRepository = orderRepository;
	}
	
	private Burger burgerDTOtoBurger(final BurgerDTO burgerDTO) {
		Burger burger = burgerFactory.create(burgerDTO.getId());

		if (burgerDTO.getExtras() != null) {
			List<Ingredient> extras = ingredientsDTOtoIngredients(burgerDTO.getExtras());
			for (Ingredient extra : extras)
				burger.addIngredient(extra);
		}
		
		return burger;
	}

	private List<Burger> burgersDTOtoBurgers(final List<BurgerDTO> burgersDTO) {
		final List<Burger> burgers = new ArrayList<Burger>();

		for (BurgerDTO burgerDTO : burgersDTO) {
			burgers.add(burgerDTOtoBurger(burgerDTO));
		}

		return burgers;
	}

	private List<Ingredient> ingredientsDTOtoIngredients(final List<Long> ingredientsDTO) {
		final List<Ingredient> ingredients = new ArrayList<Ingredient>();

		for (Long ingredientDTO : ingredientsDTO)
			ingredients.add(ingredientFactory.create(ingredientDTO));

		return ingredients;
	}

	@Override
	public Order addOrder(final OrderDTO orderDTO) {

		final List<BurgerDTO> burgersDTO = orderDTO.getBurgers();

		if (CollectionUtils.isEmpty(burgersDTO))
			throw new BurgerNotFoundException();
		
		final List<Burger> burgers = burgersDTOtoBurgers(burgersDTO);
		
		Order order = new Order();
		order.setBurgers(burgers);
		orderRepository.add(order);
		return order;
	}

	@Override
	public Order getOrder(final Long orderId) {
		final Optional<Order> order = orderRepository.findById(orderId);

		if (!order.isPresent())
			throw new OrderNotFoundException(orderId);
		return order.get();

	}

	@Override
	public Order updateOrder(final Long orderId, final Order order) {
		order.setId(orderId);
		orderRepository.update(order);
		return order;
	}

	@Override
	public void deleteOrder(final Long orderId) {
		final Optional<Order> order = orderRepository.findById(orderId);

		if (!order.isPresent())
			throw new OrderNotFoundException(orderId);

		orderRepository.remove(order.get());
	}

	@Override
	public Collection<Order> findAll() {
		final List<Order> orders = orderRepository.findAll();

		if (CollectionUtils.isEmpty(orders))
			throw new OrderNotFoundException();

		return orders;
	}

	@Override
	public Collection<Burger> getBurgersByOrder(final Long orderId) {
		final Optional<Order> order = orderRepository.findById(orderId);

		if (!order.isPresent())
			throw new OrderNotFoundException(orderId);

		final List<Burger> burgers = order.get().getBurgers();

		if (CollectionUtils.isEmpty(burgers))
			throw new BurgerNotFoundException();

		return burgers;
	}

}
