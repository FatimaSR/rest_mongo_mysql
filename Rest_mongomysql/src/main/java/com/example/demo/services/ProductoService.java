package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.documentos.Producto;
import com.example.demo.interfaces.IProductoService;
import com.example.demo.repository.ProductoRepository;


@Service
public class ProductoService implements IProductoService {

	@Autowired 
	ProductoRepository productorepository;
	
	@Override
	public void add(Producto producto) {
		productorepository.save(producto);
	}

	@Override
	public List<Producto> list_all() {
		return productorepository.findAll();
	}

	@Override
	public Producto busqueda_id_producto(int producto) {
		return productorepository.findById(producto).orElse(null);
	}

	@Override
	public void modificar_producto(Producto producto) {
		productorepository.save(producto);
		
	}

	@Override
	public void eliminar_producto_by_id(int producto) {
		productorepository.deleteById(producto);

		
	}

}
