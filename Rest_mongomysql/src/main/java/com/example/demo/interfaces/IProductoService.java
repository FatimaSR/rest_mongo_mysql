package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.documentos.Producto;
public interface IProductoService {
	public void add(Producto product);
	public List<Producto> list_all();
	public Producto busqueda_id_producto(int product);
	public void modificar_producto(Producto product);
	public void eliminar_producto_by_id(int product);
}



