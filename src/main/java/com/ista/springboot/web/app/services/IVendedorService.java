package com.ista.springboot.web.app.services;

import java.util.List;

import com.ista.springboot.web.app.apirest.models.entity.Vendedor;

public interface IVendedorService {
	public List<Vendedor> findAll();
	public Vendedor save(Vendedor v);
	public Vendedor findById(Long id);
	public void delete(Long id);
}
