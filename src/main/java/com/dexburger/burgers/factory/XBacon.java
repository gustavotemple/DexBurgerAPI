package com.dexburger.burgers.factory;

import com.dexburger.burgers.BurgersInfo;
import com.dexburger.burgers.model.Burger;

class XBacon extends Burger {

	XBacon() {
		super(BurgersInfo.XBACON.getId(), BurgersInfo.XBACON.getName());
	}

}
