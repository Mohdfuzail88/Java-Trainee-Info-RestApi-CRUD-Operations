package com.restapi.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapper {

	ObjectMapper objectMapper(){
		return new ObjectMapper();
		
	}
}
