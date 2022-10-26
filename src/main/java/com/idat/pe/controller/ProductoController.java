package com.idat.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.idat.pe.model.ProductosModel;
import com.idat.pe.service.ProductoService;

@RestController
@RequestMapping("/producto/v1")
public class ProductoController {
	
	@Autowired
	private ProductoService service;
	
	@GetMapping("/listar")
	public ResponseEntity<List<ProductosModel>> listar(){
		
		return new ResponseEntity<>(service.listar(),HttpStatus.OK);
		
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Void> guardar(@RequestBody ProductosModel p){
		service.guardar(p);
		return new ResponseEntity<Void>(HttpStatus.CREATED);		
	}
	
		
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProductosModel> obtener(@PathVariable Integer id){
		
		ProductosModel p = service.obtener(id);
		
		if( p != null) {
			return new ResponseEntity<ProductosModel>(p, HttpStatus.OK);
		}else {
			return new ResponseEntity<ProductosModel>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody ProductosModel producto){
		
		ProductosModel p = service.obtener(producto.getIdproducto());
		
		if( p != null) {
			service.actualizar(producto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void>eliminar(@PathVariable Integer id){
		
		ProductosModel p = service.obtener(id);

		if(p != null) {
			service.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	

}
