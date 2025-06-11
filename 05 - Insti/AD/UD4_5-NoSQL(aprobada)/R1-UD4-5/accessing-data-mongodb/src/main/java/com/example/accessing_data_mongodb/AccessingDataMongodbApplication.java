package com.example.accessing_data_mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataMongodbApplication implements CommandLineRunner {

	@Autowired
	private ClienteRepositorio repositorio;

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataMongodbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositorio.deleteAll();

		// Guarda algunos clientes
		repositorio.save(new Cliente("Ana", "García"));
		repositorio.save(new Cliente("Luis", "García"));

		// Obtener todos los clientes
		System.out.println("Clientes encontrados con findAll():");
		for (Cliente cliente : repositorio.findAll()) {
			System.out.println(cliente);
		}

		// Buscar cliente por nombre
		System.out.println("\nCliente encontrado con findByNombre('Ana'):");
		System.out.println(repositorio.findByNombre("Ana"));

		// Buscar clientes por apellido
		System.out.println("\nClientes encontrados con findByApellido('García'):");
		for (Cliente cliente : repositorio.findByApellido("García")) {
			System.out.println(cliente);
		}
	}
}
