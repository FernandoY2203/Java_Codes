package br.com.yuji.entities;

import br.com.yuji.controller.exception.UnsuportedMathOperationException;

public class MathCalc {
	
	public static Double sum(String num1, String num2) {
		if(!isNumeric(num1) || !isNumeric(num2)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!!");
		}
		
		return convertToDouble(num1) + convertToDouble(num2);
	}
	
	public static Double sub(String num1, String num2) {
		if(!isNumeric(num1) || !isNumeric(num2)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!!");
		}
		
		return convertToDouble(num1) - convertToDouble(num2);
	}
	
	public static Double mult(String num1, String num2) {
		if(!isNumeric(num1) || !isNumeric(num2)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!!");
		}
		
		return convertToDouble(num1) * convertToDouble(num2);
	}
	
	public static Double div(String num1, String num2) {
		if(!isNumeric(num1) || !isNumeric(num2)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!!");
		}
		
		return convertToDouble(num1) / convertToDouble(num2);
	}
	
	public static Double med(String num1, String num2) {
		if(!isNumeric(num1) || !isNumeric(num2)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!!");
		}
		
		return (convertToDouble(num1) + convertToDouble(num2)) / 2; 
	}
	
	public static Double sqrt(String num1) {
		if(!isNumeric(num1)) {
			throw new UnsuportedMathOperationException("Please set a numeric value!!");
		}
		
		return Math.sqrt(convertToDouble(num1));
	}
	
	
	private static Double convertToDouble(String strNum) {
		if(strNum == null) {
			return 0d;
		}
		else if(isNumeric(strNum)) {
			String num = strNum.replaceAll(",", ".");
			
			return Double.parseDouble(num);
		}
		else {
			return 0d;
		}
	}
	
	private static Boolean isNumeric(String strNum) {
		if(strNum == null) {
			return false;
		}
		else {
			String num = strNum.replaceAll(",", ".");
			return num.matches("[-+]?[0-9]*\\.?[0-9]+");
		}
	}
}
