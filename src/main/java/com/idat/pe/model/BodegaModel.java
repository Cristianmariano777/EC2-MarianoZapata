package com.idat.pe.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bodega")
public class BodegaModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idbodega;
	private String nombre;
	private String direccion;
	
	@OneToMany (mappedBy = "bodega")
	private List<ProductosModel> productos;
	
	public Integer getIdbodega() {
		return idbodega;
	}
	public void setIdbodega(Integer idbodega) {
		this.idbodega = idbodega;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	

}
