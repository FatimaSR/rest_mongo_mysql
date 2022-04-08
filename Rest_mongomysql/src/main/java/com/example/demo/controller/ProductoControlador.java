package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.documentos.Producto;
import com.example.demo.interfaces.IProductoService;



@RestController
public class ProductoControlador {

	@Autowired
	IProductoService productoservice;
	
	@PostMapping("/add")
	public int add(@RequestBody Producto producto) {
		System.out.println(producto);
		Producto productoaux = productoservice.busqueda_id_producto(producto.getId());
		if (productoaux == null) {
			productoservice.add(producto);
			return 0;
		} else {
			return 1;
		}
	}
	
	
	@GetMapping("/list_all")
	public List<Producto> list_all(){
		return productoservice.list_all();
	}
	
	@GetMapping("/find_by_producto/{producto}")
	public Producto get_producto_by_id(@PathVariable("producto") int producto) {
		Producto productoaux = productoservice.busqueda_id_producto(producto);
		if (productoaux == null) {
			return new Producto();
		} else {
			return productoaux;
		}

	}
	
	@GetMapping("/delete_by_producto/{producto}")
	public Integer delete_producto_by_id(@PathVariable("producto") int producto) {
		Producto productoaux = productoservice.busqueda_id_producto(producto);
		if (productoaux == null) {
			return 1;
		} else {
			productoservice.eliminar_producto_by_id(producto);
			return 0;
		}

	}

	@PutMapping("/update")
	public Integer update_user(@RequestBody Producto producto) {
		System.out.println(producto);
		Producto productoaux = productoservice.busqueda_id_producto(producto.getId());
		if (productoaux == null) {
			return 1;
		} else {
			productoservice.modificar_producto(producto);
			return 0;
		}
	}


}
