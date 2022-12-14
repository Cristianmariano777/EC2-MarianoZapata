package com.idat.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.pe.model.BodegaModel;

@Repository
public interface BodegaRepository extends JpaRepository<BodegaModel, Integer> {

}
