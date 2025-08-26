package com.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//Write appropriate annotation
@ResponseStatus(HttpStatus.NOT_FOUND)
public class AssetInvalidException extends Exception {

	public AssetInvalidException(String message) {
		super(message);
	}
}