package com.restapi.exceptions;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.restapi.utils.MyResponseHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value=RuntimeException.class)
	//@ResponseStatus(value=HttpStatus.ALREADY_REPORTED)
	public ResponseEntity<Object> exceptionHandler(){
		return MyResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Id not found", null); 
		
	}
	@ExceptionHandler(value = {ArithmeticException.class,NullPointerException.class} )
	public ResponseEntity<Object> exceptionHandler1(){
		return MyResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "null pointer exception", null); 
		
	}

	@ExceptionHandler(value=MethodArgumentNotValidException.class)
	public ResponseEntity<Object> methodANVEHandler(MethodArgumentNotValidException ex){
		Map<String, String> map = new HashMap<String, String>();
		ex.getBindingResult()
		.getAllErrors()
		.forEach((error)->{
			 String fieldName=((FieldError) error).getField();
			 String errorMessage=error.getDefaultMessage();
			 map.put(fieldName, errorMessage);
		});
		return MyResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false,
				"server side error", map);
		
	}
	
//	@ExceptionHandler(value=Exception.class)
//	public ResponseEntity<Object> exceptionHandler3(){
//		return MyResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Exception", null); 
//		
//	}

}
