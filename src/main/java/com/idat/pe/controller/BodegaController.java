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

import com.idat.pe.model.BodegaModel;
import com.idat.pe.service.BodegaService;

@RestController
@RequestMapping("/bodega/v1")
public class BodegaController {
	
	@Autowired
	private BodegaService service;
	
	@GetMapping("/listar")
	public ResponseEntity<List<BodegaModel>> listar(){
		
		return new ResponseEntity<>(service.listar(),HttpStatus.OK);
		
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Void> guardar(@RequestBody BodegaModel p){
		service.guardar(p);
		return new ResponseEntity<Void>(HttpStatus.CREATED);		
	}
	
		
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<BodegaModel> obtener(@PathVariable Integer id){
		
		BodegaModel p = service.obtener(id);
		
		if( p != null) {
			return new ResponseEntity<BodegaModel>(p, HttpStatus.OK);
		}else {
			return new ResponseEntity<BodegaModel>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody BodegaModel bodega){
		
		BodegaModel p = service.obtener(bodega.getIdbodega());
		
		if( p != null) {
			service.actualizar(bodega);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void>eliminar(@PathVariable Integer id){
		
		BodegaModel p = service.obtener(id);

		if(p != null) {
			service.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	


}
