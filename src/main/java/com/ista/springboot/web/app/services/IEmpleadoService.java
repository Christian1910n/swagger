package com.ista.springboot.web.app.services;

import com.ista.springboot.web.app.apirest.models.entity.Cliente;
import com.ista.springboot.web.app.apirest.models.entity.Empleado;

import java.util.List;

public interface IEmpleadoService {

    public List<Empleado> findAll();

    public Empleado  save(Empleado e);
    public Empleado findById(Long id);

    public void delete(Long id);
}
