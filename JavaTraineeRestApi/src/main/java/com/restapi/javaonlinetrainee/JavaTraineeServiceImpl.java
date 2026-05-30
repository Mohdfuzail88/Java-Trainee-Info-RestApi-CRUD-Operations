package com.restapi.javaonlinetrainee;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import tools.jackson.databind.ObjectMapper;
@Service
public class JavaTraineeServiceImpl implements JavaTraineeService {
	
	JavaTraineeRepository javaTraineRepository;
	
	ObjectMapper mapper;

	
	public JavaTraineeServiceImpl(JavaTraineeRepository javaTraineRepository, ObjectMapper mapper) {
	
		this.javaTraineRepository = javaTraineRepository;
		this.mapper = mapper;
	}

	@Override 
	public JavaTraineeDto registerTrainee(JavaTraineeDto dto) {
	
	JavaTraineeEntity convertValue = mapper.convertValue(dto,JavaTraineeEntity.class);
		JavaTraineeEntity entity=javaTraineRepository.save(convertValue);
		JavaTraineeDto dto2 = mapper.convertValue(entity,JavaTraineeDto.class);
		
		return dto2;
	}

	@Override
	public List<JavaTraineeDto> registerAllTrainee(List<JavaTraineeDto> dto) {
		  
		
		List<JavaTraineeEntity> convertValue = Arrays.asList(mapper.convertValue(dto,JavaTraineeEntity
[].class));	
		List<JavaTraineeEntity> entity=javaTraineRepository.saveAll(convertValue);
		
		List<JavaTraineeDto> dto3 = Arrays.asList(mapper.convertValue(entity,JavaTraineeDto[].class));
		
		return dto3;
	}

	@Override
	public List<JavaTraineeDto> findAllTrainee() {
		List<JavaTraineeEntity> all=javaTraineRepository.findAll();
		List<JavaTraineeDto> l1 = Arrays.asList(mapper.convertValue
				(all,JavaTraineeDto[].class));	
	return l1;
	}

	@Override
	public JavaTraineeDto findByIdTrainee(String id) {
		JavaTraineeEntity byId=javaTraineRepository.findById(id).orElseThrow(RuntimeException::new);
		
		JavaTraineeDto convertValue=mapper.convertValue(byId, JavaTraineeDto.class);
		
		return convertValue;
	}

	
      
	

	@Override
	public String deleteJavaTrainee(String id) {
		javaTraineRepository.deleteById(id);
		return "trainee deleted";
	}

	@Override
	public JavaTraineeDto updateJavaTrainee(JavaTraineeDto dto, String  id) {
		Optional<JavaTraineeEntity> optional  =javaTraineRepository.findById(id);
		  System.out.println(optional);
			JavaTraineeEntity convertValue = mapper.convertValue(dto,JavaTraineeEntity.class);
			convertValue.setId(id);
			JavaTraineeEntity  entity =javaTraineRepository.save(convertValue);
			JavaTraineeDto dto4 = mapper.convertValue(entity,JavaTraineeDto.class);
			
				
				return dto4;
		
	}
}
