package com.example.demo.documentos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Producto {
	@Id
	private int id;
	private int idcategoria;
	private String producto;
	private int precio;
	
	public Producto() {
		super();
	}

	public Producto(int id, int idcategoria, String producto, int precio) {
		super();
		this.id = id;
		this.idcategoria = idcategoria;
		this.producto = producto;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(int idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", idcategoria=" + idcategoria + ", producto=" + producto + ", precio=" + precio
				+ "]";
	}
	
	
}