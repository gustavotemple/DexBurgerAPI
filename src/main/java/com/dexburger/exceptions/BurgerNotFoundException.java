package com.dexburger.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BurgerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final String MESSAGE = "Lanche nao encontrado";

	public BurgerNotFoundException() {
		super(MESSAGE);
	}

	public BurgerNotFoundException(Long id) {
		super(MESSAGE + ": " + id);
	}
}
