package com.dexburger.burgers.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BurgerValidator.class)
@Documented
public @interface Burger {

	String message() default "Lanche fora do cardapio";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
