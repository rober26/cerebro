package com.example.accessing_data_mongodb;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepositorio extends MongoRepository<Cliente, String> {
    Cliente findByNombre(String nombre);
    List<Cliente> findByApellido(String apellido);
}