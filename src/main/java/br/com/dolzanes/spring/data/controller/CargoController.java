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

import br.com.dolzanes.spring.data.dto.CargoDTO;
import br.com.dolzanes.spring.data.model.Cargo;
import br.com.dolzanes.spring.data.service.CargoService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api/cargos")
public class CargoController {
	
	@Autowired
	private CargoService cargoService;
	
	@GetMapping
	public ResponseEntity<List<Cargo>> getAllCargos() {
		try {
			List<Cargo> cargo = cargoService.getAllCargos();
            return ResponseEntity.status(HttpStatus.OK).body(cargo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}
	
	@PostMapping
    public ResponseEntity<Cargo> postCargo(@RequestBody CargoDTO dto) {
		try {
			Cargo cargo = cargoService.create(dto);
            return ResponseEntity.status(HttpStatus.OK).body(cargo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<Cargo> getCargoById(@PathVariable(required=true) int id) {
		try {
			Cargo cargo = cargoService.getCargoById(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(cargo);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cargo> putCargo(@PathVariable(value = "id") int id, @RequestBody CargoDTO dto) {
		try {
			Cargo cargo = cargoService.update(id, dto);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(cargo);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Cargo> deleteCargo(@PathVariable(value = "id") int id) {
		try {
			cargoService.delete(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
}
