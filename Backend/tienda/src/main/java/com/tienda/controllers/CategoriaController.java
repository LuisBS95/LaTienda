package com.tienda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tienda.dtos.SubCtaegoria;
import com.tienda.entities.CategoriaEntity;

import com.tienda.services.CategoriaService;
@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/listar")
	public List<CategoriaEntity> listarCategorias(){
		
		return categoriaService.encontraCategorias();
	}
	
	@GetMapping("/super")
	public List<SubCtaegoria> listarSuper(){
		return categoriaService.EncontrarSubcategoria();
	}
	
	@GetMapping("/sub/{id}")
	public List<CategoriaEntity> listarSub(@PathVariable(name = "id") Long id){
		return categoriaService.SubCategorias(id);
	}
	
	@GetMapping("/id/{id}")
	public CategoriaEntity listarCat(@PathVariable(name = "id") Long id){
		return categoriaService.Categoria(id);
	}

}
