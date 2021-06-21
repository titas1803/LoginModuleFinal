package com.cg.login.exceptions;

import java.util.List;

import org.springframework.validation.FieldError;

public class ValidateProductException extends Exception {

private final List<FieldError> errors;
	
	public ValidateProductException() {
		super();
		this.errors = null;

	}

	public ValidateProductException(String msg) {
		super(msg);
		this.errors = null;
	}
	
	public ValidateProductException(List<FieldError> errors) {
		this.errors=errors;
	}

	public List<FieldError> getErrors() {
		return errors;
	}
}
