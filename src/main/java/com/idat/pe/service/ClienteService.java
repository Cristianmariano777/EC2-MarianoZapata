package com.idat.pe.service;

import java.util.List;

import com.idat.pe.model.ClienteModel;

public interface ClienteService {
	
	List<ClienteModel> listar();
	ClienteModel obtener(Integer id);
	void guardar (ClienteModel cliente);
	void eliminar (Integer id);
	void actualizar (ClienteModel cliente);
	

}
