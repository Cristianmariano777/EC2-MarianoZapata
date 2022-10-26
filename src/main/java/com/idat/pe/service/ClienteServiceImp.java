package com.idat.pe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.pe.model.ClienteModel;
import com.idat.pe.repository.ClienteRepository;

@Service
public class ClienteServiceImp implements ClienteService {
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public List<ClienteModel> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public ClienteModel obtener(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public void guardar(ClienteModel cliente) {
		// TODO Auto-generated method stub
		repository.save(cliente);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public void actualizar(ClienteModel cliente) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(cliente);

	}

}
