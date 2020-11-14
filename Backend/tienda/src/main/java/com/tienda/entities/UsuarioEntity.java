package com.tienda.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.tienda.dtos.PedidosDTO;

import lombok.Data;

@Entity
@Data
@Table(name = "usuario")
public class UsuarioEntity implements Serializable {
	
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long idUsuario;
	
	private String nombre;
	
	private String apellido;
	
	private String email;
	
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;
//
	@JoinColumn(name = "id_direccion", referencedColumnName = "id_direccion")
	@ManyToOne( cascade = CascadeType.PERSIST  )
	private DireccionEntity direccion;
//	
	@OneToMany(mappedBy = "usuarioEntity", cascade = CascadeType.ALL,fetch = FetchType.LAZY  )
	private List<PedidosEntity> pedidos;

	public UsuarioEntity() {
		
	}

	public UsuarioEntity(Long idUsuario, String nombre, String apellido, String email, Date fechaNacimiento,
			DireccionEntity direccion, List<PedidosEntity> pedidos) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.pedidos = pedidos;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}
	public UsuarioEntity(Long idUsuario) {
		this.idUsuario = idUsuario;
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

	public DireccionEntity getDireccion() {
		return direccion;
	}

	public void setDireccion(DireccionEntity direccion) {
		this.direccion = direccion;
	}

	public List<PedidosEntity> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<PedidosEntity> pedidos) {
		this.pedidos = pedidos;
	}

	public UsuarioEntity(Long idUsuario, String nombre, String apellido, String email, Date fechaNacimiento,
			DireccionEntity direccion) {
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
	}

//	@Override
//	public String toString() {
//		return "UsuarioEntity [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido + ", email="
//				+ email + ", fechaNacimiento=" + fechaNacimiento + ", direccion=" + direccion + ", pedidos=" + pedidos
//				+ "]";
//	}

	

	

	
	
}
