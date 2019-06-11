package com.dexburger.prices.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.dexburger.burgers.BurgersInfo;
import com.dexburger.burgers.factory.BurgerFactory;
import com.dexburger.burgers.model.Burger;
import com.dexburger.exceptions.BurgerNotFoundException;
import com.dexburger.ingredients.IngredientsInfo;
import com.dexburger.ingredients.factory.IngredientFactory;
import com.dexburger.ingredients.model.Ingredient;
import com.dexburger.order.model.Order;
import com.dexburger.prices.IngredientsPrices;
import com.dexburger.prices.discounts.CheeseDiscount;
import com.dexburger.prices.discounts.LightDiscount;
import com.dexburger.prices.discounts.MeatDiscount;
import com.dexburger.prices.discounts.PercentageDiscount;
import com.dexburger.prices.discounts.QuantityDiscount;

@RunWith(MockitoJUnitRunner.Silent.class)
public class PriceServiceTest {

	@Mock
	private IngredientsPrices ingredientsPrices;
	private IngredientFactory ingredientFactory;
	private BurgerFactory burgerFactory;
	private PriceService priceService;

	private List<QuantityDiscount> quantityDiscounts = new ArrayList<QuantityDiscount>();
	private List<PercentageDiscount> percentageDiscounts = new ArrayList<PercentageDiscount>();

	private BigDecimal letucePrice;
	private BigDecimal baconPrice;
	private BigDecimal meatPrice;
	private BigDecimal eggPrice;
	private BigDecimal cheesePrice;

	@Before
	public void setUp() {
		ingredientFactory = new IngredientFactory(ingredientsPrices);
		burgerFactory = new BurgerFactory(ingredientFactory);

		quantityDiscounts.add(new CheeseDiscount());
		quantityDiscounts.add(new MeatDiscount());
		percentageDiscounts.add(new LightDiscount());
		priceService = new PriceServiceImpl(quantityDiscounts, percentageDiscounts);

		letucePrice = new BigDecimal("0.40");
		baconPrice = new BigDecimal("2.00");
		meatPrice = new BigDecimal("3.00");
		eggPrice = new BigDecimal("0.80");
		cheesePrice = new BigDecimal("1.50");

		Mockito.when(ingredientsPrices.getLetuce()).thenReturn(letucePrice);
		Mockito.when(ingredientsPrices.getBacon()).thenReturn(baconPrice);
		Mockito.when(ingredientsPrices.getMeat()).thenReturn(meatPrice);
		Mockito.when(ingredientsPrices.getEgg()).thenReturn(eggPrice);
		Mockito.when(ingredientsPrices.getCheese()).thenReturn(cheesePrice);
	}

	@Test
	public void testXEggPrice() {
		Burger burger = burgerFactory.create(BurgersInfo.XEGG);

		priceService.calculatePrice(burger);

		assertEquals(burger.getPrice(), eggPrice.add(meatPrice).add(cheesePrice));
	}

	@Test
	public void testXBaconPrice() {
		Burger burger = burgerFactory.create(BurgersInfo.XBACON);

		priceService.calculatePrice(burger);

		assertEquals(burger.getPrice(), baconPrice.add(meatPrice).add(cheesePrice));
	}

	@Test
	public void testXEggBaconPrice() {
		Burger burger = burgerFactory.create(BurgersInfo.XEGGBACON);

		priceService.calculatePrice(burger);

		assertEquals(burger.getPrice(), eggPrice.add(baconPrice).add(meatPrice).add(cheesePrice));
	}

	@Test
	public void testXBurgerPrice() {
		Burger burger = burgerFactory.create(BurgersInfo.XBURGER);

		priceService.calculatePrice(burger);

		assertEquals(burger.getPrice(), meatPrice.add(cheesePrice));
	}

	@Test
	public void testCheeseDiscount() {
		Burger burger = burgerFactory.create(BurgersInfo.XEGG);

		Ingredient cheese = ingredientFactory.create(IngredientsInfo.CHEESE);

		burger.addIngredient(cheese).addIngredient(cheese);

		priceService.calculatePrice(burger);
		priceService.applyDiscounts(burger);

		assertEquals(burger.getPrice(), eggPrice.add(meatPrice).add(cheesePrice).add(cheesePrice));
	}

	@Test
	public void testMeatDiscount() {
		Burger burger = burgerFactory.create(BurgersInfo.XBACON);

		Ingredient meat = ingredientFactory.create(IngredientsInfo.MEAT);

		burger.addIngredient(meat).addIngredient(meat);

		priceService.calculatePrice(burger);
		priceService.applyDiscounts(burger);

		assertEquals(burger.getPrice(), baconPrice.add(cheesePrice).add(meatPrice).add(meatPrice));
	}

	@Test
	public void testLightDiscount() {
		Burger burger = burgerFactory.create(BurgersInfo.XBURGER);

		Ingredient letuce = ingredientFactory.create(IngredientsInfo.LETUCE);

		burger.addIngredient(letuce).addIngredient(letuce);

		priceService.calculatePrice(burger);
		priceService.applyDiscounts(burger);

		BigDecimal price = meatPrice.add(cheesePrice).add(letucePrice).add(letucePrice);

		assertEquals(burger.getPrice(), price.subtract(percentage(price, LightDiscount.DISCOUNT)));
	}

	@Test
	@SuppressWarnings("serial")
	public void testOrderPrice() {
		Order order = new Order();

		Burger xBurger = burgerFactory.create(BurgersInfo.XBURGER);
		Burger xEgg = burgerFactory.create(BurgersInfo.XEGG);
		Burger xBacon = burgerFactory.create(BurgersInfo.XBACON);

		order.setBurgers(new ArrayList<Burger>() {
			{
				add(xBurger);
				add(xEgg);
				add(xBacon);
			}
		});

		priceService.calculatePrice(xBurger);
		priceService.calculatePrice(xEgg);
		priceService.calculatePrice(xBacon);

		priceService.calculatePrice(order);

		assertEquals(order.getPrice(), meatPrice.add(cheesePrice).add(meatPrice).add(cheesePrice).add(eggPrice)
				.add(meatPrice).add(cheesePrice).add(baconPrice));
	}

	@Test(expected = BurgerNotFoundException.class)
	public void testOrderWithNoBurgers() {
		Order order = new Order();
		priceService.calculatePrice(order);
	}

	private BigDecimal percentage(BigDecimal base, BigDecimal pct) {
		return base.multiply(pct).scaleByPowerOfTen(-2);
	}

}
