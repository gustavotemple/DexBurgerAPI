package com.dexburger.burgers.factory;

import com.dexburger.burgers.BurgersInfo;
import com.dexburger.burgers.model.Burger;

class XEgg extends Burger {

	XEgg() {
		super(BurgersInfo.XEGG.getId(), BurgersInfo.XEGG.getName());
	}

}