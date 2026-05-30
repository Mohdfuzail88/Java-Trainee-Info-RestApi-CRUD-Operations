package com.restapi.javaonlinetrainee;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JavaTraineeDto {
	private String id;
@NotEmpty(message="Name cannot be blank")
@Size(min = 3,max=20,message = "min 3 and max 20 character is allowed")
private String name;
@Email
@NotEmpty(message="Email cannot be blank")
private String email;
@Size(min = 10,max=10,message = "min 10 and max 10 digits is allowed")
@NotEmpty(message="Mobile cannot be blank")
private String mobile;
@NotEmpty(message="Name cannot be blank")
@Size(min = 4,max=20,message = "min 4 and max 20 character is allowed")
private String cource;
@DecimalMin("2000.0")
@DecimalMax("20000.0") 
@NotNull(message="must be greater than or equal to 2000.0")
private Double fees;
}
