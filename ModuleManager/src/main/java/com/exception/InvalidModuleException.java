package com.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Spring annotation to automatically return a 404 NOT FOUND status when this exception is thrown
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidModuleException extends Exception {
    
    /**
     * Constructor that accepts a custom error message.
     * @param message The detail message explaining why the exception was thrown.
     */
    public InvalidModuleException(String message) {
		// Pass the message to the parent Exception class
		super(message);
	}
}