package com.dexburger.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IngredientNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final String MESSAGE = "Ingrediente nao encontrado";

	public IngredientNotFoundException() {
		super(MESSAGE);
	}

	public IngredientNotFoundException(Long id) {
		super(MESSAGE + ": " + id);
	}
}
