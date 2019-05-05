package com.dexburger.ingredients.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IngredientExtraValidator.class)
@Documented
public @interface IngredientExtra {

	String message() default "Ingrediente fora do cardapio";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
