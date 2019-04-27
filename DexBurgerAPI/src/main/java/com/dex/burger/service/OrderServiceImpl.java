package com.dex.burger.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dex.burger.exceptions.BurgerNotFoundException;
import com.dex.burger.exceptions.OrderNotFoundException;
import com.dex.burger.models.burger.Burger;
import com.dex.burger.models.burger.BurgerDTO;
import com.dex.burger.models.burger.factory.BurgerFactory;
import com.dex.burger.models.ingredient.Ingredient;
import com.dex.burger.models.ingredient.factory.IngredientFactory;
import com.dex.burger.models.order.Order;
import com.dex.burger.models.order.OrderDTO;
import com.dex.burger.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private BurgerFactory burgerFactory;

	@Autowired
	private IngredientFactory ingredientFactory;

	private List<Burger> burgersDTOtoBurgers(final List<BurgerDTO> burgersDTO) {
		final List<Burger> burgers = new ArrayList<Burger>();

		for (BurgerDTO burgerDTO : burgersDTO) {
			List<Ingredient> extras = ingredientsDTOtoIngredients(burgerDTO.getExtras());

			Burger burger = burgerFactory.create(burgerDTO.getId());
			for (Ingredient extra : extras)
				burger.addIngredient(extra);

			burgers.add(burger);
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
	public Order addOrder(OrderDTO orderDTO) {

		final List<BurgerDTO> burgersDTO = orderDTO.getBurgers();

		if (burgersDTO.isEmpty())
			throw new BurgerNotFoundException();
		
		final List<Burger> burgers = burgersDTOtoBurgers(burgersDTO);
		
		Order order = new Order();
		order.setBurgers(burgers);
		OrderRepository.getInstance().add(order);
		return order;
	}

	@Override
	public Order getOrder(Long orderId) {
		final Order order = OrderRepository.getInstance().findById(orderId);

		if (Objects.isNull(order))
			throw new OrderNotFoundException(orderId);
		return order;

	}

	@Override
	public Order updateOrder(Long orderId, Order order) {
		order.setId(orderId);
		OrderRepository.getInstance().update(order);
		return order;
	}

	@Override
	public void deleteOrder(Long orderId) {
		final Order order = OrderRepository.getInstance().findById(orderId);

		if (Objects.isNull(order))
			throw new OrderNotFoundException(orderId);

		OrderRepository.getInstance().remove(order);
	}

	@Override
	public Collection<Order> findAll() {
		final List<Order> orders = OrderRepository.getInstance().findAll();

		if (orders.isEmpty())
			throw new OrderNotFoundException();

		return orders;
	}

	@Override
	public Collection<Burger> getBurgersByOrder(Long orderId) {
		final Order order = OrderRepository.getInstance().findById(orderId);

		if (Objects.isNull(order))
			throw new OrderNotFoundException(orderId);

		final List<Burger> burgers = order.getBurgers();

		if (burgers.isEmpty())
			throw new BurgerNotFoundException();

		return burgers;
	}

}
