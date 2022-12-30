package br.com.dolzanes.spring.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.dolzanes.spring.data.dto.EmployeeDTO;
import br.com.dolzanes.spring.data.model.Employee;
import br.com.dolzanes.spring.data.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired 
	private EmployeeRepository repository;
	
	public Employee create(EmployeeDTO dto) {
		Employee employee = new Employee();
		employee.setName(dto.getName());
		employee.setEmail(dto.getEmail());
		employee.setAge(dto.getAge());
		employee.setSalary(dto.getSalary());
		employee.setDateHiring(dto.getDateHiring());
		
		return repository.save(employee);
	}
	
	public List<Employee> getNameLike(EmployeeDTO dto) {
		return (List<Employee>) repository.findByNameContaining(dto.getName());
	}
	
	public Page<Employee> getAllEmployees(Integer page, Integer size) {
		Pageable pageable = PageRequest.of(page, size, Sort.unsorted());
		return (Page<Employee>) repository.findAll(pageable);
	}
}
