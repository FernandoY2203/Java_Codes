package br.com.yuji.controller.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> allExceptions(Exception ex, WebRequest request){
		ExceptionResponse response = new ExceptionResponse(Instant.now(), ex.getMessage(), request.getDescription(false));
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);	
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> notFoundException(Exception ex, WebRequest request){
		ExceptionResponse response = new ExceptionResponse(Instant.now(), ex.getMessage(), request.getDescription(false));
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);	
	}
}
