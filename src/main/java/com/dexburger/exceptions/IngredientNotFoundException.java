package com.dexburger.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IngredientNotFoundException extends RuntimeException {

	private static String MESSAGE = "Ingrediente nao encontrado";

	public IngredientNotFoundException() {
		super(MESSAGE);
	}

	public IngredientNotFoundException(Long id) {
		super(MESSAGE + ": " + id);
	}
}
