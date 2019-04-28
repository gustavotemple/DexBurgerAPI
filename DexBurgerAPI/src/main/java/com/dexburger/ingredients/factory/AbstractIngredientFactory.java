package com.dexburger.ingredients.factory;

import com.dexburger.ingredients.IngredientsInfo;

interface AbstractIngredientFactory<T> {

	T create(IngredientsInfo ingredientInfo);

	T create(Long id);

}
