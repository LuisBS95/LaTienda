package com.tienda.services;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tienda.dtos.Combinada;
import com.tienda.dtos.IProdPedCat;
import com.tienda.dtos.Icombinada;
import com.tienda.dtos.Ipedidos;
import com.tienda.dtos.ProductosCat;
import com.tienda.dtos.UsuarioDTO;
import com.tienda.entities.PedidosEntity;
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

	@Override
	@Transactional
	public UsuarioEntity registrar(UsuarioDTO usuario) {
		
		if(usuario!= null) {
			UsuarioEntity usuarioen = UsuarioDTOToEntiry(usuario);
			usuarioDao.save(usuarioen);
			return usuarioen;
		}
		return null;
	}
	
	//Usuario DTO to entity
	
	public static UsuarioEntity UsuarioDTOToEntiry(UsuarioDTO usuario) {
		
		UsuarioEntity usuarioen = new UsuarioEntity();
		
		usuarioen.setNombre(usuario.getNombre());
		usuarioen.setApellido(usuario.getApellido());
		usuarioen.setEmail(usuario.getEmail());
		usuarioen.setFechaNacimiento(usuario.getFechaNacimiento());
		usuarioen.setPassword(usuario.getPassword());
		
		return usuarioen;
		
	}

	@Override
	@Transactional(readOnly = true)
	public boolean existeUsuario(String email) {
		List<String> emails = usuarioDao.findbyEmail(email);
		
		if(emails.size()==0) {
		return false;
		}
		else {
		return true;
		}
	}

	@Override
	public List<String> existeUsu(String email) {
		
		return usuarioDao.findbyEmail(email);
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public UsuarioEntity encontrarUsuario(Long id) {
		
		return usuarioDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Ipedidos> encontrarPedidos(Long id) {
		
		return usuarioDao.findPedidos(id);
	}

	@Override
	public List<IProdPedCat> encontrarProductos(Long idPedido) {
		
		return usuarioDao.findProductos(idPedido);
	}
	
	
	

}
