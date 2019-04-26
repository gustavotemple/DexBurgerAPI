package com.dex.burger.models.burger.factory;

import com.dex.burger.models.burger.Burger;
import com.dex.burger.models.burger.BurgerInfo;

class XBacon extends Burger {

	XBacon() {
		super(BurgerInfo.XBACON.getId(), BurgerInfo.XBACON.getName());
	}

}
