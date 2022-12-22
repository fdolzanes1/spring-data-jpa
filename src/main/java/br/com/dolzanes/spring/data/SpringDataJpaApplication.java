package br.com.dolzanes.spring.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.dolzanes.spring.data.orm.Cargo;
import br.com.dolzanes.spring.data.repository.CargoRepository;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {
	
	private final CargoRepository repository;
	
	public SpringDataJpaApplication(CargoRepository repository) {
		this.repository = repository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Cargo cargo = new Cargo();
		cargo.setDescricao("DESENVOLVEDOR");
		
		repository.save(cargo);
	}

}
