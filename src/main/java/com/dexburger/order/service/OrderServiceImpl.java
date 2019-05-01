package com.dexburger.order.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
import com.dexburger.prices.service.PriceService;

@Service
public class OrderServiceImpl implements OrderService {

	private BurgerFactory burgerFactory;
	private IngredientFactory ingredientFactory;
	private OrderRepository orderRepository;
	private PriceService priceService;

	@Autowired
	public OrderServiceImpl(BurgerFactory burgerFactory, IngredientFactory ingredientFactory,
			OrderRepository orderRepository, PriceService priceService) {
		this.burgerFactory = burgerFactory;
		this.ingredientFactory = ingredientFactory;
		this.orderRepository = orderRepository;
		this.priceService = priceService;
	}
	
	/**
	 * 
	 * @param order      Order
	 * @param burgersDTO List<BurgerDTO>
	 */
	private void burgersDTOtoBurgers(final Order order, final List<BurgerDTO> burgersDTO) {
		for (BurgerDTO burgerDTO : burgersDTO) {
			order.addBurger(burgerDTOtoBurger(burgerDTO));
		}
	}

	/**
	 * burgerDTOtoBurger
	 * 
	 * @param burgerDTO BurgerDTO
	 * @return Burger
	 */
	private Burger burgerDTOtoBurger(final BurgerDTO burgerDTO) {
		Burger burger = burgerFactory.create(burgerDTO.get_id());

		if (!CollectionUtils.isEmpty(burgerDTO.getExtras())) {
			List<Ingredient> extras = ingredientsDTOtoIngredients(burgerDTO.getExtras());
			for (Ingredient extra : extras)
				burger.addIngredient(extra);
		}
		
		calculateFinalPrice(burger);

		return burger;
	}
	
	/**
	 * applyDiscount
	 * 
	 * @param burger Burger
	 */
	private void calculateFinalPrice(Burger burger) {
		priceService.calculatePrice(burger);
		priceService.applyDiscounts(burger);
	}

	/**
	 * ingredientsDTOtoIngredients
	 * 
	 * @param ingredientsDTO List<Long>
	 * @return List<Ingredient>
	 */
	private List<Ingredient> ingredientsDTOtoIngredients(final List<Long> ingredientsDTO) {
		List<Ingredient> ingredients = new ArrayList<Ingredient>();

		for (Long ingredientDTO : ingredientsDTO)
			ingredients.add(ingredientFactory.create(ingredientDTO));

		return ingredients;
	}

	@Override
	public Order addOrder(final OrderDTO orderDTO) {
		List<BurgerDTO> burgersDTO = orderDTO.getBurgers();

		if (CollectionUtils.isEmpty(burgersDTO))
			throw new BurgerNotFoundException();

		Order order = new Order();
		burgersDTOtoBurgers(order, burgersDTO);
		priceService.calculatePrice(order);
		orderRepository.add(order);
		return order;
	}

	@Override
	public Order getOrder(final Long orderId) {
		return orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));
	}

	@Override
	public Order updateOrder(final Long orderId, final OrderDTO orderDTO) {
		List<BurgerDTO> burgersDTO = orderDTO.getBurgers();
		
		if (CollectionUtils.isEmpty(burgersDTO))
			throw new BurgerNotFoundException();

		Order order = getOrder(orderId);
		burgersDTOtoBurgers(order, burgersDTO);
		priceService.calculatePrice(order);
		orderRepository.update(order);
		return order;
	}

	@Override
	public void deleteOrder(final Long orderId) {
		orderRepository.remove(getOrder(orderId));
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
		Order order = getOrder(orderId);

		List<Burger> burgers = order.getBurgers();

		if (CollectionUtils.isEmpty(burgers))
			throw new BurgerNotFoundException();

		return burgers;
	}

}
