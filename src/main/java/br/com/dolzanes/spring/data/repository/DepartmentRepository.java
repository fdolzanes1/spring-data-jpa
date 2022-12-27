package br.com.dolzanes.spring.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.dolzanes.spring.data.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {
	
	List<Department> findByDescriptionContaining(String description);
	
}
