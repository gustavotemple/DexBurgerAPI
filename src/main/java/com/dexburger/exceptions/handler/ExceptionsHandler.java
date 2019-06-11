package com.dexburger.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.dexburger.exceptions.BurgerNotFoundException;
import com.dexburger.exceptions.IngredientNotFoundException;
import com.dexburger.exceptions.OrderNotFoundException;

@RestControllerAdvice
public class ExceptionsHandler {

	@ExceptionHandler(value = { BurgerNotFoundException.class, IngredientNotFoundException.class,
			OrderNotFoundException.class })
	public ResponseEntity<Object> handleNotFound(RuntimeException exception) {
		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleValid(MethodArgumentNotValidException exception) {
		return new ResponseEntity<>(exception.getBindingResult().getFieldError().getDefaultMessage(),
				HttpStatus.BAD_REQUEST);
	}

}
