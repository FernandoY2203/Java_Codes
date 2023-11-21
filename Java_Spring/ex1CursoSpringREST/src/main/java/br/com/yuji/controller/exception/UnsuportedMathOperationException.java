package br.com.yuji.controller.exception;

public class UnsuportedMathOperationException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public UnsuportedMathOperationException(String message) {
		super(message);
	}
	
	
}
