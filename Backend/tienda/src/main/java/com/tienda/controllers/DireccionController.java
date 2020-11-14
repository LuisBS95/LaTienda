package com.tienda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.entities.DireccionEntity;
import com.tienda.services.DireccionService;

@RestController
@RequestMapping("/direccion")
public class DireccionController {
	
	@Autowired
	private DireccionService direccionService;
	
	@GetMapping("/listar")
	public List<DireccionEntity> listarDirecciones(){
		
		return direccionService.encontraDirecciones();
	}
	

}
