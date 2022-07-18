package com.ista.springboot.web.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.springboot.web.app.apirest.models.entity.Vendedor;
import com.ista.springboot.web.app.models.dao.IVendedorDao;

@Service
public class VendedorServicempl implements IVendedorService{
	
	@Autowired
	private IVendedorDao vendedorDao;

	@Override
	
	public List<Vendedor> findAll() {		
		return (List<Vendedor>) vendedorDao.findAll();
	}

	@Override
	@Transactional
	public Vendedor save(Vendedor v) {
		return vendedorDao.save(v);
	}
	

	@Override
	@Transactional(readOnly = true)
	public Vendedor findById(Long id) {		
		return vendedorDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		vendedorDao.deleteById(id);		
	}
	
	
}
