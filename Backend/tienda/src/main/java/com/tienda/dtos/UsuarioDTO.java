package com.tienda.dtos;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tienda.entities.DireccionEntity;
import com.tienda.entities.PedidosEntity;
import com.tienda.entities.UsuarioEntity;

public class UsuarioDTO {
	
	@Autowired
	private UsuarioEntity u;
	
	private Long idUsuario;
	
	private String nombre;
	
	private String apellido;
	
	private String email;
	
	private Date fechaNacimiento;
	
	private List<PedidosEntity> pedidos;
	
	private DireccionEntity direccion;	
	
	
	public UsuarioDTO(UsuarioEntity u) {
	
		this.idUsuario = u.getIdUsuario();
		this.nombre = u.getNombre();
		this.apellido = u.getApellido();
		this.email = u.getEmail();
		this.fechaNacimiento = u.getFechaNacimiento();
		this.pedidos = u.getPedidos();
		this.direccion = u.getDireccion();
		
	}

	public List<PedidosEntity> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidosEntity> pedidos) {
		this.pedidos = pedidos;
	}

	public DireccionEntity getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionEntity direccion) {
		this.direccion = direccion;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	
	
	
	
	
	
}
