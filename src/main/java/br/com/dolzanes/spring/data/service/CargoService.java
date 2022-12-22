package br.com.dolzanes.spring.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.dolzanes.spring.data.dto.CargoDTO;
import br.com.dolzanes.spring.data.model.Cargo;
import br.com.dolzanes.spring.data.repository.CargoRepository;

@Component
public class CargoService {

	@Autowired 
	private CargoRepository repository;
	
	public Cargo create(CargoDTO dto) {
		Cargo cargo = new Cargo();
		cargo.setDescricao(dto.getDescricao());
		return repository.save(cargo);
	}
	
	public List<Cargo> getAllCargos() {
		return (List<Cargo>) repository.findAll();
	}
	
}
