package com.dex.burger.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BurgerNotFoundException extends RuntimeException {

	private static String MESSAGE = "Lanche nao encontrado";

	public BurgerNotFoundException() {
		super(MESSAGE);
	}

	public BurgerNotFoundException(Long id) {
		super(MESSAGE + ": " + id);
	}
}