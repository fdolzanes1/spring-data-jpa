package br.com.dolzanes.spring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.dolzanes.spring.data.model.Cargo;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer> {
	
}
