package br.com.dolzanes.spring.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dolzanes.spring.data.dto.EmployeeDTO;
import br.com.dolzanes.spring.data.model.Employee;
import br.com.dolzanes.spring.data.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
    public ResponseEntity<Employee> postEmployee(@RequestBody EmployeeDTO dto) {
		try {
			Employee employee = employeeService.create(dto);
            return ResponseEntity.status(HttpStatus.OK).body(employee);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
	
	@GetMapping("/name")
	public ResponseEntity<List<Employee>> getNameLike(@RequestBody EmployeeDTO dto) {
		try {
			List<Employee> employee = employeeService.getNameLike(dto);
            return ResponseEntity.status(HttpStatus.OK).body(employee);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}
	
	@GetMapping
	public ResponseEntity<Page<Employee>> getAllEmployees(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "5") Integer size) {
		try {
			Page<Employee> employee = employeeService.getAllEmployees(page, size);
            return ResponseEntity.status(HttpStatus.OK).body(employee);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}

}
