package br.com.dolzanes.spring.data.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="employees")
@Setter
@Getter
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;	
	private String name;
	private String email;
	private Integer age;
	private Double salary;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate dateHiring;

}
