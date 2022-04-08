package com.example.demo.interfaces;
import java.util.ArrayList;

import com.example.demo.model.Categoria;

public interface ICategoriaService {
	public void alta_categoria(Categoria categ);
	public Categoria busqueda_id_categoria(int categ);
	public void modificar_categoria(Categoria categ);
	public void eliminar_categoria_by_id(int categ);
	public ArrayList<Categoria> listado_categorias();
	
}


