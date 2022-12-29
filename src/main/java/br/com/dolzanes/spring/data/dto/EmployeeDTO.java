package br.com.dolzanes.spring.data.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeDTO {
	
	private String name;
	private String email;
	private Integer age;
	private Double salary;
	private LocalDate dateHiring;

}
