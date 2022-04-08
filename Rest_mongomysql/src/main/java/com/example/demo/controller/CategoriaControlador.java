package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.interfaces.ICategoriaService;
import com.example.demo.model.Categoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaControlador {

	@Autowired
	ICategoriaService categoriaservice;

	@GetMapping("/list_all")
	public ArrayList<Categoria> get_categorias() {
		return categoriaservice.listado_categorias();
	}

	@PostMapping("/add")
	public Integer add_categoria(@RequestBody Categoria categoria) {
		System.out.println(categoria);
		Categoria categoriaaux = categoriaservice.busqueda_id_categoria(categoria.getId());
		if (categoriaaux == null) {
			categoriaservice.alta_categoria(categoria);
			return 0;
		} else {
			return 1;
		}
	}

	@GetMapping("/find_by_categoria/{categoria}")
	public Categoria get_categoria_by_id(@PathVariable("categoria") int categoria) {
		Categoria categoriaaux = categoriaservice.busqueda_id_categoria(categoria);
		if (categoriaaux == null) {
			return new Categoria();
		} else {
			return categoriaaux;
		}

	}

	@GetMapping("/delete_by_categoria/{categoria}")
	public Integer delete_categoria_by_id(@PathVariable("categoria") int categoria) {
		Categoria categoriaaux = categoriaservice.busqueda_id_categoria(categoria);
		if (categoriaaux == null) {
			return 1;
		} else {
			categoriaservice.eliminar_categoria_by_id(categoria);
			return 0;
		}

	}

	@PutMapping("/update")
	public Integer update_user(@RequestBody Categoria categoria) {
		System.out.println(categoria);
		Categoria categoriaaux = categoriaservice.busqueda_id_categoria(categoria.getId());
		if (categoriaaux == null) {
			return 1;
		} else {
			categoriaservice.modificar_categoria(categoria);
			return 0;
		}
	}

}