package br.com.dolzanes.spring.data.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.dolzanes.spring.data.model.Employee;

public class EmployeeSpecification {
	
	public static Specification<Employee> likeName(String name) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%"+ name +"%");
	}
	
	public static Specification<Employee> likeEmail(String email) {
		return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("email"), "%"+ email +"%");
	}

}
