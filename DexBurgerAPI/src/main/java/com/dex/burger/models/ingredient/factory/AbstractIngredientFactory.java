package com.dex.burger.models.ingredient.factory;

import com.dex.burger.models.ingredient.IngredientInfo;

interface AbstractIngredientFactory<T> {
	
	T create(IngredientInfo ingredientInfo) ;

}
