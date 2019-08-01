package com.yash.ppmtoolapp.exception;

public class IncorrectEmailException extends RuntimeException{
	public IncorrectEmailException(String errorMessage) {
		super(errorMessage);
	}
}
