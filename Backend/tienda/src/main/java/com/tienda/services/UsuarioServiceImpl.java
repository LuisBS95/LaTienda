package com.tienda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tienda.dtos.Combinada;
import com.tienda.dtos.Icombinada;
import com.tienda.entities.UsuarioEntity;
import com.tienda.repositories.UsuarioDao;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<UsuarioEntity> encontraUsuarios() {
		
		return (List<UsuarioEntity>) usuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Icombinada> combinado() {
		
		return usuarioDao.findCom();
	}

}
