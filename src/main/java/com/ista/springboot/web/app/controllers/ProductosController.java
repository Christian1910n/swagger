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

import com.ista.springboot.web.app.apirest.models.entity.Producto;
import com.ista.springboot.web.app.services.IProductoService;


@CrossOrigin(origins = {"http://localhost:8080"})
@RestController
@RequestMapping("/api")
public class ProductosController {

	@Autowired
	private IProductoService productoservice;
	
	
	@GetMapping("/listarproductos")
	public List<Producto> index() {
		return productoservice.findAll();	
	}
	
	
	@GetMapping("/buscarproductos/{id}")
    public Producto findById(@PathVariable Long id) {	
		return productoservice.findById(id);	
	}
	
	@PostMapping("/guardarproductos")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto save(@RequestBody Producto producto) {	
	return productoservice.save(producto);
		
	}
	
	
   @DeleteMapping("/borrarproductos/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public void delete(@PathVariable long id) {	
	   productoservice.delete(id);	
 	}
   
   
   @PutMapping("/modificarproductos/{id}")
   @ResponseStatus (HttpStatus.CREATED)
   public Producto update(@RequestBody Producto producto , @PathVariable Long id) {
	   
	   Producto productoActual = productoservice.findById(id);
	   productoActual.setNombre(producto.getNombre());
	   productoActual.setDescripcion(producto.getDescripcion());
	   productoActual.setCosto(producto.getCosto());
	   productoActual.setStock(producto.getStock());
	
	   return productoservice.save(productoActual);
	   
   }
}
