package com.dex.burger.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends RuntimeException {

	private static String MESSAGE = "Pedido nao encontrado";

	public OrderNotFoundException() {
		super(MESSAGE);
	}

	public OrderNotFoundException(Long id) {
		super(MESSAGE + ": " + id);
	}
}
