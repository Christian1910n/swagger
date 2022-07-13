package com.ista.springboot.web.app.models.dao;

import com.ista.springboot.web.app.apirest.models.entity.Cliente;
import com.ista.springboot.web.app.apirest.models.entity.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface IEmpleadoDao extends CrudRepository <Empleado,Long> {
}
