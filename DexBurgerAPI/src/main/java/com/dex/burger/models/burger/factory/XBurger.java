package com.dex.burger.models.burger.factory;

import com.dex.burger.models.burger.Burger;
import com.dex.burger.models.burger.BurgerInfo;

class XBurger extends Burger {

	XBurger() {
		super(BurgerInfo.XBURGER.getId(), BurgerInfo.XBURGER.getName());
	}

}
