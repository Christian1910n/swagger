package com.ista.springboot.web.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ista.springboot.web.app.apirest.models.entity.Cliente;
import com.ista.springboot.web.app.services.IClienteService;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	//listar todos los clientes
	@GetMapping("/listar")
	public List<Cliente> indext(){

		return clienteService.findAll();
	}

	//crear cliente
	@PostMapping("/crearCliente")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente save(@RequestBody Cliente cliente){

		return clienteService.save(cliente);
	}

	//buscar cliente por id
	@GetMapping("/clientes/{id}")
	public Cliente findById(@PathVariable Long id){
		return clienteService.findById(id);
	}


	//editar cliente
	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente editar(@RequestBody Cliente cliente, @PathVariable Long id){
		Cliente clienteactual=clienteService.findById(id);
		clienteactual.setApellido(cliente.getApellido());
		clienteactual.setNombre(cliente.getNombre());
		clienteactual.setEmail(cliente.getEmail());
		return clienteService.save(clienteactual);
	}

	//eliminar cliente por id
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void eliminar(@PathVariable long id){
		clienteService.delete(id);
	}


}
