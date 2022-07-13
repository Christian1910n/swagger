package com.ista.springboot.web.app.services;

import java.util.List;

import com.ista.springboot.web.app.apirest.models.entity.Cliente;

public interface IClienteService {
	/*Listar todo los clientes*/
	public List<Cliente> findAll();

	public Cliente  save(Cliente c);
	public Cliente findById(Long id);

	public void delete(Long id);

	
}
