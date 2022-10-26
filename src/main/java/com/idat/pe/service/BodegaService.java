package com.idat.pe.service;

import java.util.List;

import com.idat.pe.model.BodegaModel;

public interface BodegaService {
	
	List<BodegaModel> listar();
	BodegaModel obtener(Integer id);
	void guardar (BodegaModel bodega);
	void eliminar (Integer id);
	void actualizar (BodegaModel bodega);
	

	
	
}
