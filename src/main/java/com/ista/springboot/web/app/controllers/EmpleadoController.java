package com.ista.springboot.web.app.controllers;

import com.ista.springboot.web.app.apirest.models.entity.Cliente;
import com.ista.springboot.web.app.apirest.models.entity.Empleado;
import com.ista.springboot.web.app.services.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
@RequestMapping("/api")
public class EmpleadoController {
    @Autowired
    private IEmpleadoService empleadoService;


    @GetMapping("/listar")
    public List<Empleado> indext(){
        return empleadoService.findAll();
    }

    //crear empleado
    @PostMapping("/crearEmpleado")
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado save(@RequestBody Empleado empleado){
        return empleadoService.save(empleado);
    }

    @GetMapping("/empleado/{id}")
    public Empleado findById(@PathVariable Long id){

        return empleadoService.findById(id);
    }

    @PutMapping("/empleado/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado editar(@RequestBody Empleado empleado, @PathVariable Long id){
        Empleado empleadoactual=empleadoService.findById(id);
        empleadoactual.setApellido(empleado.getApellido());
        empleadoactual.setCi(empleado.getCi());
        empleadoactual.setNombre(empleado.getNombre());
        empleadoactual.setDireccion(empleado.getDireccion());
        empleadoactual.setDno(empleado.getDno());
        empleadoactual.setFecha_n(empleado.getFecha_n());
        empleadoactual.setSexo(empleado.getSexo());
        empleadoactual.setSalario(empleado.getSalario());
        empleadoactual.setSuperci(empleado.getSuperci());
        return empleadoService.save(empleadoactual);
    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void eliminar(@PathVariable long id){
        empleadoService.delete(id);
    }


}

