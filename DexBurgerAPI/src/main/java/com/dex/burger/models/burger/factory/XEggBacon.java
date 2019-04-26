package com.dex.burger.models.burger.factory;

import com.dex.burger.models.burger.Burger;
import com.dex.burger.models.burger.BurgerInfo;

class XEggBacon extends Burger {

	XEggBacon() {
		super(BurgerInfo.XEGGBACON.getId(), BurgerInfo.XEGGBACON.getName());
	}

}
