package com.ista.springboot.web.app.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.springboot.web.app.apirest.models.entity.Cliente;
import com.ista.springboot.web.app.models.dao.IClienteDao;

@Service
public class ClienteServiceImpl implements IClienteService {

	//autowired=Inyectar la interfaz del IclienteDao
	@Autowired
	//Declaro el atributo del Dao
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public Cliente save(Cliente c) {
		return clienteDao.save(c);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}


	@Override
	@Transactional
	public void delete(Long id) {
		 clienteDao.deleteById(id);
	}


}
