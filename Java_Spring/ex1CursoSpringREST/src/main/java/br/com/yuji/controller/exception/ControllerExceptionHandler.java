package br.com.yuji.controller.exception;

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
	
	@ExceptionHandler(UnsuportedMathOperationException.class)
	public final ResponseEntity<ExceptionResponse> badRequestException(Exception ex, WebRequest request){
		ExceptionResponse response = new ExceptionResponse(Instant.now(), ex.getMessage(), request.getDescription(false));
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);	
	}
}
