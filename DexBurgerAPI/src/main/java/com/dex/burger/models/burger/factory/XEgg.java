package com.dex.burger.models.burger.factory;

import com.dex.burger.models.burger.Burger;
import com.dex.burger.models.burger.BurgerInfo;

class XEgg extends Burger {

	XEgg() {
		super(BurgerInfo.XEGG.getId(), BurgerInfo.XEGG.getName());
	}

}
