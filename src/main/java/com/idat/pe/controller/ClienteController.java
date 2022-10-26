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

import com.idat.pe.model.ClienteModel;
import com.idat.pe.service.ClienteService;

@RestController
@RequestMapping("/cliente/v1")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping("/listar")
	public ResponseEntity<List<ClienteModel>> listar(){
		
		return new ResponseEntity<>(service.listar(),HttpStatus.OK);
		
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Void> guardar(@RequestBody ClienteModel p){
		service.guardar(p);
		return new ResponseEntity<Void>(HttpStatus.CREATED);		
	}
	
		
	@RequestMapping(path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<ClienteModel> obtener(@PathVariable Integer id){
		
		ClienteModel p = service.obtener(id);
		
		if( p != null) {
			return new ResponseEntity<ClienteModel>(p, HttpStatus.OK);
		}else {
			return new ResponseEntity<ClienteModel>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<Void> editar(@RequestBody ClienteModel cliente){
		
		ClienteModel p = service.obtener(cliente.getIdcliente());
		
		if( p != null) {
			service.actualizar(cliente);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void>eliminar(@PathVariable Integer id){
		
		ClienteModel p = service.obtener(id);

		if(p != null) {
			service.eliminar(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	}
	


}
