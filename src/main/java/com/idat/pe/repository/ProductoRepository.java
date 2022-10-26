package com.idat.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.pe.model.ProductosModel;

@Repository
public interface ProductoRepository extends JpaRepository<ProductosModel, Integer> {

}
