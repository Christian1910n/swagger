package com.ista.springboot.web.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ista.springboot.web.app.apirest.models.entity.Vendedor;
import com.ista.springboot.web.app.services.IVendedorService;

@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
@RequestMapping("/api")
public class VendedorController {
	
	@Autowired
	private IVendedorService vendedorService;
	
	@GetMapping("/listavendedor")
	public List<Vendedor> indext(){
        return vendedorService.findAll();
    }

	@PostMapping("/crearvendedor")
    @ResponseStatus(HttpStatus.CREATED)
    public Vendedor save(@RequestBody Vendedor vendedor){
        return vendedorService.save(vendedor);
    }

    @GetMapping("/buscarvendedor/{id}")
    public Vendedor findById(@PathVariable Long id){
        return vendedorService.findById(id);
    }

    @PutMapping("/editarvendedor/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Vendedor editar(@RequestBody Vendedor vendedor, @PathVariable Long id){
    	Vendedor vendedoractual=vendedorService.findById(id);
    	vendedoractual.setNombre(vendedor.getNombre());
    	vendedoractual.setApellido(vendedor.getApellido());
    	vendedoractual.setDireccion(vendedor.getDireccion());
    	vendedoractual.setTelefono(vendedor.getTelefono());
    	vendedoractual.setEmail(vendedor.getEmail());
    	return vendedorService.save(vendedoractual);
    }

    @DeleteMapping("/eliminarvendedor/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void eliminarVendedor(@PathVariable long id){
    	vendedorService.delete(id);
    }
}
