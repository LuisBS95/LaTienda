package com.tienda.services;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.tienda.dtos.Combinada;
import com.tienda.dtos.Icombinada;
import com.tienda.dtos.UsuarioDTO;
import com.tienda.entities.UsuarioEntity;


public interface UsuarioService {
	
	public List<UsuarioEntity> encontraUsuarios();
	
	public List<Icombinada> combinado();
	
	public UsuarioEntity registrar(UsuarioDTO usuario);

}
