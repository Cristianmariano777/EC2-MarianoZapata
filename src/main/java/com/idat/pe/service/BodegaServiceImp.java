package com.idat.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.model.BodegaModel;
import com.idat.pe.repository.BodegaRepository;

@Service
public class BodegaServiceImp implements BodegaService {
	
	@Autowired
	private BodegaRepository repository;

	@Override
	public List<BodegaModel> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public BodegaModel obtener(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public void guardar(BodegaModel bodega) {
		// TODO Auto-generated method stub
		repository.save(bodega);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public void actualizar(BodegaModel bodega) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(bodega);

	}

}
