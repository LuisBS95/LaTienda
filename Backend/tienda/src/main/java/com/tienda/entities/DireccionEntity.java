package com.tienda.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "direccion")
public class DireccionEntity implements Serializable {
	
	private static final long serialVersionUID =1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_direccion")
	private Long idDireccion;
	
	private String calle;
	
	private String numero;
	
	private String cp;
	
	private String municipio;
	
	private String estado;
	
	private String colonia;
	
//	@OneToMany(mappedBy = "direccion", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY )
//	private List<UsuarioEntity> usuario;

	public DireccionEntity() {
		
	}

	public DireccionEntity(Long idDireccion) {
		
		this.idDireccion = idDireccion;
	}

	public DireccionEntity(Long idDireccion, String calle, String numero, String cp, String municipio, String estado,
			String colonia) {
		
		this.idDireccion = idDireccion;
		this.calle = calle;
		this.numero = numero;
		this.cp = cp;
		this.municipio = municipio;
		this.estado = estado;
		this.colonia = colonia;
	}

	public Long getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(Long idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getColonia() {
		return colonia;
	}

	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

//	public List<UsuarioEntity> getUsuario() {
//		return usuario;
//	}
//
//	public void setUsuario(List<UsuarioEntity> usuario) {
//		this.usuario = usuario;
//	}

//	@Override
//	public String toString() {
//		return "DireccionEntity [idDireccion=" + idDireccion + ", calle=" + calle + ", numero=" + numero + ", cp=" + cp
//				+ ", municipio=" + municipio + ", estado=" + estado + ", colonia=" + colonia + "]";
//	}
	
	

}
