package com.exception;

import java.time.LocalDate;
import java.util.stream.Collectors; // Add this import

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDate.now(), ex.getMessage(),
				request.getDescription(false), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(InvalidMembershipException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(RuntimeException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDate.now(), ex.getMessage(),
				request.getDescription(false), HttpStatus.NOT_FOUND.getReasonPhrase());
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);	
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
		HttpHeaders headers, HttpStatusCode status, WebRequest request) {	
		    
		    // This logic now collects ALL validation error messages, not just the first one.
		    String collectedErrors = ex.getBindingResult()
		        .getAllErrors()
		        .stream()
		        .map(error -> error.getDefaultMessage())
		        .collect(Collectors.joining(", "));

		    ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDate.now(), "Validation Failed",
				collectedErrors, HttpStatus.BAD_REQUEST.getReasonPhrase());
		    
		    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}