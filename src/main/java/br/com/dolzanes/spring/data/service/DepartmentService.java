package br.com.dolzanes.spring.data.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dolzanes.spring.data.dto.DepartmentDTO;
import br.com.dolzanes.spring.data.model.Department;
import br.com.dolzanes.spring.data.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired 
	private DepartmentRepository repository;
	
	public Department create(DepartmentDTO dto) {
		Department department = new Department();
		
		department.setDescription(dto.getDescription());
		return repository.save(department);
	}
	
	public List<Department> getAllCargos() {
		return (List<Department>) repository.findAll();
	}
	
	public List<Department> getCargosByDescricao(DepartmentDTO dto) {
		// return (List<Department>) repository.findByDescriptionContaining(dto.getDescription());
		return (List<Department>) repository.findByDescription(dto.getDescription());
	}
	
	public Department getDepartmentById(int id) {
		Optional<Department> optionalDepartment = repository.findById(id);
		return optionalDepartment.get();
	}
	
	public Department update(int id, DepartmentDTO dto) {
		Department department = repository.findById(id).get();
		department.setDescription(dto.getDescription());
		return repository.save(department);
	}
	
	public void delete(int id) {
		repository.deleteById(id);
	}
	
}
