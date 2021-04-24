package com.examen.rest.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.rest.models.Cliente;
import com.examen.rest.repositories.ClienteRepo;

@RestController
//@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
@RequestMapping("/NutriNET/Cliente")
public class ClienteController {

	@Autowired
	private ClienteRepo repo;

	@PostMapping("/")
	public Map<String, Object> crearCliente(@Validated @RequestBody Cliente c) {
		try {
			int idRandom = (int) (Math.random() * (999));
			c.setFecha_Creacion(new Date());
			c.setCliente_ID(idRandom);
//			System.out.println(c.getNombre());
//			System.out.println(repo.findByNombre(c.getNombre()).isEmpty());
			if (repo.findByNombre(c.getNombre()).isEmpty()) {
				if (repo.findByCorreoElectronico(c.getCorreoElectronico()).isEmpty()) {
					return respuesta(repo.insert(c), 0);
				} else {
					return respuesta("Ya existe un cliente con este correo electronico: " + c.getCorreoElectronico(),
							-1);
				}

			} else {
				return respuesta("Ya existe un cliente con este nombre: " + c.getNombre(), -1);
			}

		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			return respuesta(e.getMessage(), -1);
		}

	}

	@GetMapping("/")
	public Map<String, Object> obtenerClientes() {
		try {
			Map<String, Object> response = new HashMap<String, Object>();
			Pageable page = PageRequest.of(0, 100);
			Page<Cliente> clientePage = repo.findAll(page);
			response.put("Cve_Error", 0);
			response.put("Cve_Mensaje", clientePage.getContent());
			return response;
		} catch (Exception e) {
			return respuesta(e.getMessage(), -1);
		}
	}

	@GetMapping("/{Cliente_ID}")
	public Map<String, Object> obtenerUnCliente(@PathVariable int Cliente_ID) {
		try {
			Object cliente = repo.findById(Cliente_ID);
//			System.out.println(cliente);
			if (cliente.equals(null)) {
				return respuesta(repo.findById(Cliente_ID), 0);
			}
			return respuesta("No se encontró el cliente", -1);
		} catch (Exception e) {
			return respuesta(e.getMessage(), -1);
		}

	}

	@PutMapping("/{id}")
	public Map<String, Object> actualizarCliente(@PathVariable int id, @Validated @RequestBody Cliente c) {
		try {
			Optional<Cliente> optionalCliente = repo.findById(id);
			Cliente oldCliente = optionalCliente.get();
//			Cliente clienteActualizar = comparar(oldCliente, c);
			if (repo.findByNombre(c.getNombre()).isEmpty() || c.getNombre() == null) {
				if (repo.findByCorreoElectronico(c.getCorreoElectronico()).isEmpty() || c.getCorreoElectronico() == null ) {
					return respuesta(repo.save(comparar(oldCliente, c)), 0);
				} else {
					return respuesta("Ya existe un cliente con este correo electronico: " + c.getCorreoElectronico(),
							-1);
				}
			} else {
				return respuesta("Ya existe un cliente con este nombre: " + c.getNombre(), -1);
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getCause());
			return respuesta(e.getMessage(), -1);
		}
		
		
	}

	private Map<String, Object> respuesta(Object msj, int code) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("Cve_Error", code);
		response.put("Cve_Mensaje", msj);
		return response;
	}

	private Cliente comparar(Cliente viejo, Cliente nuevo) {
		if (viejo.getNombre_Usuario() != nuevo.getNombre_Usuario() && nuevo.getNombre_Usuario() != null) {
			viejo.setNombre_Usuario(nuevo.getNombre_Usuario());
		}
		if (viejo.getContraseña() != nuevo.getContraseña() && nuevo.getContraseña() != null) {
			viejo.setContraseña(nuevo.getContraseña());
		}
		if (viejo.getNombre() != nuevo.getNombre() && nuevo.getNombre() != null) {
			viejo.setNombre(nuevo.getNombre());
		}
		if (viejo.getApellidos() != nuevo.getApellidos() && nuevo.getApellidos() != null) {

			viejo.setApellidos(nuevo.getApellidos());
		}
		if (viejo.getCorreoElectronico() != nuevo.getCorreoElectronico() && nuevo.getCorreoElectronico() != null) {
			viejo.setCorreoElectronico(nuevo.getCorreoElectronico());
		}
		if (viejo.getEdad() != nuevo.getEdad() && nuevo.getEdad() != 0) {
			viejo.setEdad(nuevo.getEdad());
		}
		if (viejo.getEstatura() != nuevo.getEstatura() && nuevo.getEstatura() != 0) {
			viejo.setEstatura(nuevo.getEstatura());
		}
		if (viejo.getPeso() != nuevo.getPeso() && nuevo.getPeso() != 0) {
			viejo.setPeso(nuevo.getPeso());
		}
		if (viejo.getIMC() != nuevo.getIMC() && nuevo.getIMC() != 0) {
			viejo.setIMC(nuevo.getIMC());
		}
		if (viejo.getGEB() != nuevo.getGEB() && nuevo.getGEB() != 0) {
			viejo.setGEB(nuevo.getGEB());
		}
		if (viejo.getETA() != nuevo.getETA() && nuevo.getETA() != 0) {
			viejo.setETA(nuevo.getETA());
		}

//		System.out.println(viejo.toString());
		viejo.setFecha_Actualizacion(new Date());
		viejo.setFecha_Creacion(viejo.getFecha_Creacion());
		return viejo;
	}

}
