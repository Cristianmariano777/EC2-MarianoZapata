package com.idat.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.model.ProductosModel;
import com.idat.pe.repository.ProductoRepository;

@Service
public class ProductoServiceImp implements ProductoService {

	@Autowired
	private ProductoRepository repository;
	
	@Override
	public List<ProductosModel> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public ProductosModel obtener(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public void guardar(ProductosModel producto) {
		// TODO Auto-generated method stub
		repository.save(producto);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public void actualizar(ProductosModel producto) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(producto);

	}

}
