package br.com.dolzanes.spring.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dolzanes.spring.data.dto.CargoDTO;
import br.com.dolzanes.spring.data.model.Cargo;
import br.com.dolzanes.spring.data.repository.CargoRepository;
import br.com.dolzanes.spring.data.service.CargoService;

@RestController
@RequestMapping("/api/cargos")
public class CargoController {
	
	@Autowired
	private CargoService cargoService;
	
	@GetMapping
	public List<Cargo> getAllCargos() {
		return cargoService.getAllCargos();
	}
	
	@PostMapping
    public Cargo postCargo(@RequestBody CargoDTO cargo) {
        return cargoService.create(cargo);
    }
}
