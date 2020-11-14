package com.tienda.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.dtos.Combinada;
import com.tienda.dtos.Icombinada;
import com.tienda.dtos.UsuarioDTO;
import com.tienda.entities.UsuarioEntity;
import com.tienda.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping({"/listar","/",""})
	public List <UsuarioEntity> listarUsuarios(){
		
		return usuarioService.encontraUsuarios();
	}
	
	@GetMapping("/com")
	public List <Icombinada> combinada(){
		
		return usuarioService.combinado();
	}
}
