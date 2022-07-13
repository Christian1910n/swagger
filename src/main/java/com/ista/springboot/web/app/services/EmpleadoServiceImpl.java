package com.ista.springboot.web.app.services;

import com.ista.springboot.web.app.apirest.models.entity.Empleado;
import com.ista.springboot.web.app.models.dao.IEmpleadoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{
    @Autowired
    private IEmpleadoDao empleadoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Empleado> findAll() {
        return (List<Empleado>) empleadoDao.findAll();
    }

    @Override
    @Transactional
    public Empleado save(Empleado e) {
        return empleadoDao.save(e);
    }

    @Override
    @Transactional(readOnly = true)
    public Empleado findById(Long id) {
        return empleadoDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        empleadoDao.deleteById(id);
    }
}
