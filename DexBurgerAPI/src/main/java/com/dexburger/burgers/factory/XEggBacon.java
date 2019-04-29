package com.dexburger.burgers.factory;

import com.dexburger.burgers.BurgersInfo;
import com.dexburger.burgers.model.Burger;

class XEggBacon extends Burger {

	XEggBacon() {
		super(BurgersInfo.XEGGBACON.getId(), BurgersInfo.XEGGBACON.getName());
	}

}