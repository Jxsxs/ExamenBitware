package com.examen.rest.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.examen.rest.models.Cliente;

@Repository
public interface ClienteRepo extends MongoRepository<Cliente, Integer>{
	Optional<Cliente> findByNombre(String Nombre);
	Optional<Cliente> findByCorreoElectronico(String Correo_Electronico);
}
