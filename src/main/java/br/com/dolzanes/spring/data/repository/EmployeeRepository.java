package br.com.dolzanes.spring.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.dolzanes.spring.data.model.Employee;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Integer>, JpaSpecificationExecutor<Employee>{
	
	List<Employee> findByNameContaining(String name);
	
	@Query(value="SELECT e.id, e.name, e.salary FROM employees e", nativeQuery = true)
	List<EmployeeRepositoryDTO> findEmployeeSalary();
	
	public interface EmployeeRepositoryDTO {
	    Integer getId();
	    String getName();
	    Double getSalary();
	}
}
