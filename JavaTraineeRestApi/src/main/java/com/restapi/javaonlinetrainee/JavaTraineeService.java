package com.restapi.javaonlinetrainee;

import java.util.List;



public interface JavaTraineeService {

	
	
	public JavaTraineeDto registerTrainee(JavaTraineeDto dto);
	public List<JavaTraineeDto> registerAllTrainee(List<JavaTraineeDto> dto);
	public List<JavaTraineeDto> findAllTrainee();
	public JavaTraineeDto findByIdTrainee(String id);
	public JavaTraineeDto updateJavaTrainee(JavaTraineeDto dto,String id);
	public String deleteJavaTrainee(String id);
}
