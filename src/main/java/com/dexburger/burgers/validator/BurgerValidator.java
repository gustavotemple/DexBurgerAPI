package com.dexburger.burgers.validator;

import java.util.Objects;
import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.dexburger.burgers.factory.BurgerFactory;
import com.dexburger.menu.repositories.BurgerRepository;

public class BurgerValidator implements ConstraintValidator<Burger, Long> {

	@Autowired
	private BurgerFactory burgerFactory;

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		if (Objects.isNull(value)) {
			return false;
		}

		Optional<com.dexburger.burgers.model.Burger> burger = BurgerRepository.getInstance(burgerFactory)
				.findById(value);

		return burger.isPresent();
	}

}
