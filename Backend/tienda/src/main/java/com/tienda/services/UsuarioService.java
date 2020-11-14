package com.tienda.services;


import java.util.List;

import com.tienda.dtos.Combinada;
import com.tienda.dtos.Icombinada;
import com.tienda.entities.UsuarioEntity;


public interface UsuarioService {
	
	public List<UsuarioEntity> encontraUsuarios();
	
	public List<Icombinada> combinado();

}
