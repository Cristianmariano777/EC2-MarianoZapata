package com.idat.pe.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class ProductosModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idproducto;
	private String producto;
	private String descripcion;
	private double precio;
	private Integer stock;
	
	@ManyToOne
	@JoinColumn(name="idbodega", nullable = false, unique = true, foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (idbodega) references bodega (idbodega)"))
	private BodegaModel bodega;
	
	@ManyToMany
	@JoinTable(name="producto_cliente",
		joinColumns = @JoinColumn(name="idproducto", nullable = false, unique = true, foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (idproducto) references productos (idproducto)")),
		inverseJoinColumns = @JoinColumn(name="idcliente", nullable = false, unique = true, foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(idcliente) references clientes (idcliente)"))
			)
	private List<ClienteModel> clientes = new ArrayList<>();
	
	public Integer getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
		
}
