package com.dexburger.ingredients.validator;

import java.util.Objects;
import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.dexburger.ingredients.factory.IngredientFactory;
import com.dexburger.ingredients.model.Ingredient;
import com.dexburger.menu.repositories.IngredientRepository;

public class IngredientExtraValidator implements ConstraintValidator<IngredientExtra, Long> {

	@Autowired
	private IngredientFactory ingredientFactory;

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {

		if (Objects.isNull(value)) {
			return true;
		}

		Optional<Ingredient> ingredient = IngredientRepository.getInstance(ingredientFactory).findById(value);

		return ingredient.isPresent();
	}

}
