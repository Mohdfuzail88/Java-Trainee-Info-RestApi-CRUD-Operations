package com.restapi.javaonlinetrainee;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.utils.MyResponseHandler;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/javatrainee")
public class JavaTraineeController {
	JavaTraineeService javaTraineService;
	
	public JavaTraineeController(JavaTraineeService javaTraineService) {
	
		this.javaTraineService = javaTraineService;
	}
	@PostMapping("/register")
	public 	ResponseEntity<Object> registerJavaTrainee(@Valid @RequestBody JavaTraineeDto dto) {
		JavaTraineeDto registerTrainee = javaTraineService.registerTrainee(dto);
		if(registerTrainee!=null) {
			ResponseEntity<Object> entity=MyResponseHandler.generateResponse(HttpStatus.CREATED, true, "java trainee register", registerTrainee);
					return entity;
		}
		else {
			ResponseEntity<Object> entity=MyResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "someting went wrong", registerTrainee);
					return entity;
		}}
	@PostMapping("/registerAll")
	
	public ResponseEntity<List<JavaTraineeDto>> registerAllJavaTrainee(@RequestBody List<JavaTraineeDto> dto) {
		List<JavaTraineeDto> registerTrainee = javaTraineService.registerAllTrainee(dto);
	ResponseEntity<List<JavaTraineeDto>> entity=ResponseEntity.status(HttpStatus.OK).body(registerTrainee);
		return entity;	
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<JavaTraineeDto> updateJavaTrainee(@RequestBody JavaTraineeDto dto,@PathVariable String id) {
		
		JavaTraineeDto updateTrainee =javaTraineService.updateJavaTrainee(dto, id);
		return ResponseEntity.ok(updateTrainee);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteJavaTrainee(@PathVariable String id) {
		String deleteTrainee =javaTraineService.deleteJavaTrainee( id);
		return deleteTrainee;
		
	}
	@GetMapping("/findJavaTrainee/{id}")
	public ResponseEntity<Object> findJavaTrainee(@PathVariable String id) {
		
		JavaTraineeDto byIdTrainee =javaTraineService.findByIdTrainee( id);  
		if(byIdTrainee!=null) {
			ResponseEntity<Object> entity=MyResponseHandler.generateResponse(HttpStatus.OK, true, "data found", byIdTrainee);
					return entity;
		}
		else {
			ResponseEntity<Object> entity=MyResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "data not found", byIdTrainee);
					return entity;
		}
		
		
	}
	@GetMapping("/findAllJavaTrainee")
	public ResponseEntity<List<JavaTraineeDto>> findAllJavaTrainee() {
		List<JavaTraineeDto> allTrainee =javaTraineService.findAllTrainee();  
		return ResponseEntity.ok(allTrainee);
	}
//	@ExceptionHandler(value=RuntimeException.class)
//	public ResponseEntity<Object> exceptionHandler(){
//		return MyResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Id not found", null); 
//		
//	}
//	@ExceptionHandler(value = {ArithmeticException.class,NullPointerException.class} )
//	public ResponseEntity<Object> exceptionHandler1(){
//		return MyResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "null pointer exception", null); 
//		
//	}
//	@ExceptionHandler(value=Exception.class)
//	public ResponseEntity<Object> exceptionHandler3(){
//		return MyResponseHandler.generateResponse(HttpStatus.BAD_REQUEST, false, "Exception", null); 
//		
//	}


}
