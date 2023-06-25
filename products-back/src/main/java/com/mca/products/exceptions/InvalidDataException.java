package com.mca.products.exceptions;

/**
 * Exception for requests with invalid value
 *
 */
public class InvalidDataException extends RuntimeException{
	
	public InvalidDataException(String message) {	
		super(message);
	}
}
