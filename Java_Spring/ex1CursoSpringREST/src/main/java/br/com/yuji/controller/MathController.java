package br.com.yuji.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.yuji.entities.MathCalc;

@RestController
@RequestMapping(value = "/calculator")
public class MathController {
	
	@GetMapping(value = "/sum/{num1}/{num2}")
	public ResponseEntity<Double> sum(@PathVariable String num1, @PathVariable String num2){
		Double result = MathCalc.sum(num1, num2);
		
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value = "/sub/{num1}/{num2}")
	public ResponseEntity<Double> sub(@PathVariable String num1, @PathVariable String num2) {
		Double result = MathCalc.sub(num1, num2);
		
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value = "/mult/{num1}/{num2}")
	public ResponseEntity<Double> mult(@PathVariable String num1, @PathVariable String num2) {
		Double result = MathCalc.mult(num1, num2);
		
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value = "/div/{num1}/{num2}")
	public ResponseEntity<Double> div(@PathVariable String num1, @PathVariable String num2) {
		Double result = MathCalc.div(num1, num2);
		
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value = "/med/{num1}/{num2}")
	public ResponseEntity<Double> med(@PathVariable String num1, @PathVariable String num2) {
		Double result = MathCalc.med(num1, num2);
		
		return ResponseEntity.ok().body(result);
	}
	
	@GetMapping(value = "/sqrt/{num}")
	public ResponseEntity<Double> sqrt(@PathVariable String num) {
		Double result = MathCalc.sqrt(num);
		
		return ResponseEntity.ok().body(result);
	}

}
