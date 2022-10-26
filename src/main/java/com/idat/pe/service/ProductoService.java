package com.idat.pe.service;

import java.util.List;

import com.idat.pe.model.ProductosModel;

public interface ProductoService {
	
	List<ProductosModel> listar();
	ProductosModel obtener(Integer id);
	void guardar (ProductosModel producto);
	void eliminar (Integer id);
	void actualizar (ProductosModel producto);

}
