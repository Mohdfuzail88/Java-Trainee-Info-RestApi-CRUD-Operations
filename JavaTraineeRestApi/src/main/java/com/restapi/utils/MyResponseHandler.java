package com.restapi.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class MyResponseHandler {

	public static ResponseEntity<Object> generateResponse(HttpStatus httpStatus, boolean isError,String msg, Object responseBody)
	
	{
	Map<String, Object> map=new HashMap<String, Object>();
	try {
		map.put("status", httpStatus.value());
		map.put("isSuccess", isError);
		map.put("message", msg);
		map.put("data", responseBody);
		return new ResponseEntity<Object>(map,httpStatus);
	}
		catch(Exception e) {
			map.put("status", httpStatus.INTERNAL_SERVER_ERROR);
			map.put("isSuccess", isError);
			map.put("message", e.getMessage());
			map.put("data", null);
			return new ResponseEntity<Object>(map,httpStatus);
		}
	
	}
	
		

 }
