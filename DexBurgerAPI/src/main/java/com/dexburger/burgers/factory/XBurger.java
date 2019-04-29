package com.dexburger.burgers.factory;

import com.dexburger.burgers.BurgersInfo;
import com.dexburger.burgers.model.Burger;

class XBurger extends Burger {

	XBurger() {
		super(BurgersInfo.XBURGER.getId(), BurgersInfo.XBURGER.getName());
	}

}