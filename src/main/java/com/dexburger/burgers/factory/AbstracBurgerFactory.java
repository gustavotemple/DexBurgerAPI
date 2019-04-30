package com.dexburger.burgers.factory;

import com.dexburger.burgers.BurgersInfo;

interface AbstracBurgerFactory<T> {

	T create(BurgersInfo burgerInfo);
	
	T create(Long id);

}
