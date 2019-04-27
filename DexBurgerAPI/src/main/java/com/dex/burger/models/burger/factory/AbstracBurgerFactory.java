package com.dex.burger.models.burger.factory;

import com.dex.burger.models.burger.BurgerInfo;

interface AbstracBurgerFactory<T> {

	T create(BurgerInfo burgerInfo);
	
	T create(Long id);

}
