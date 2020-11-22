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
	
	private String password;
	
	

	private List<PedidosEntity> pedidos;
	
	private DireccionEntity direccion;	
	
	
	
	public UsuarioDTO() {
		
	}

	public UsuarioDTO(Long idUsuario, String nombre, String apellido, String email, Date fechaNacimiento,
			String password, List<PedidosEntity> pedidos, DireccionEntity direccion) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.password = password;
		this.pedidos = pedidos;
		this.direccion = direccion;
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
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
	
}
