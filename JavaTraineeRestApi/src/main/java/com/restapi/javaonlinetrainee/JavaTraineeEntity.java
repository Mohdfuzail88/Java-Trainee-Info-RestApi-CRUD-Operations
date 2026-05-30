package com.restapi.javaonlinetrainee;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor 
@Table(name="trainee")
public class JavaTraineeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
private String name,email,mobile,cource;
private double fees;
}

