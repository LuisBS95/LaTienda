package com.tienda.controllers;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.dtos.Combinada;
import com.tienda.dtos.Icombinada;
import com.tienda.dtos.UsuarioDTO;
import com.tienda.entities.UsuarioEntity;
import com.tienda.services.UsuarioService;

import ch.qos.logback.core.status.Status;

@CrossOrigin(origins= {"http://localhost:4200"})
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
	
	@PostMapping("/registar")
	public ResponseEntity<?> registrar(@RequestBody UsuarioDTO usuario, HttpServletResponse response){
		
		if(usuario !=null) {
			usuarioService.registrar(usuario);
			return new ResponseEntity<>(null, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/email/{email}")
	public boolean existeEmail(@PathVariable(name="email") String email) {
		return usuarioService.existeUsuario(email);
	}
	@GetMapping("/email2/{email}")
	public List<String> existeE(@PathVariable(name="email") String email) {
		return usuarioService.existeUsu(email);
	}
}
