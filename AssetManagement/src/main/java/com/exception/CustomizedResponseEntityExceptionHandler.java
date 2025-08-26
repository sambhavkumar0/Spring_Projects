package com.exception;

import java.time.LocalDate;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(
		        new java.util.Date(),
		        ex.getMessage(),
		        request.getDescription(false)
		    );
		    return new ResponseEntity<>(exceptionResponse, org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(AssetInvalidException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(
		        new java.util.Date(),
		        ex.getMessage(),
		        request.getDescription(false)
		    );
		    return new ResponseEntity<>(exceptionResponse, org.springframework.http.HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	        HttpHeaders headers, HttpStatusCode status, WebRequest request) {

	    String errorMessage = ex.getBindingResult().getFieldErrors().stream()
	        .map(err -> err.getDefaultMessage())
	        .collect(Collectors.joining(", "));

	    ExceptionResponse exceptionResponse = new ExceptionResponse(
	        LocalDate.now(),   // or LocalDateTime.now() if test expects time
	        "Validation Failed",
	        errorMessage,
	        "Bad Request"
	    );

	    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}



}