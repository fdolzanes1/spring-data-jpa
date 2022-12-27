package br.com.dolzanes.spring.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dolzanes.spring.data.dto.DepartmentDTO;
import br.com.dolzanes.spring.data.model.Department;
import br.com.dolzanes.spring.data.service.DepartmentService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping
	public ResponseEntity<List<Department>> getAllDepartments() {
		try {
			List<Department> department = departmentService.getAllCargos();
            return ResponseEntity.status(HttpStatus.OK).body(department);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}
	
	@GetMapping("/description")
	public ResponseEntity<List<Department>> getDepartmentsByDescription(@RequestBody DepartmentDTO dto) {
		try {
			List<Department> department = departmentService.getCargosByDescricao(dto);
            return ResponseEntity.status(HttpStatus.OK).body(department);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}
	
	@PostMapping
    public ResponseEntity<Department> postDepartment(@RequestBody DepartmentDTO dto) {
		try {
			Department department = departmentService.create(dto);
            return ResponseEntity.status(HttpStatus.OK).body(department);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Department> getDepartmentsById(@PathVariable(required=true) int id) {
		try {
			Department department = departmentService.getDepartmentById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(department);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Department> putDepartment(@PathVariable(value = "id") int id, @RequestBody DepartmentDTO dto) {
		try {
			Department department = departmentService.update(id, dto);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(department);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Department> deleteDepartment(@PathVariable(value = "id") int id) {
		try {
			departmentService.delete(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
