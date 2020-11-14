package com.tienda.dtos;

import org.springframework.beans.factory.annotation.Autowired;

import com.tienda.entities.DireccionEntity;

public class DireccionDTO {
	
	@Autowired
	private DireccionEntity d;
	
	private Long idDireccion;
	
	private String calle;
	
	private String numero;
	
	private String cp;
	
	private String municipio;
	
	private String estado;
	
	private String colonia;

	
	public DireccionDTO() {
		
	}


	public DireccionDTO(DireccionEntity d) {
		
		this.idDireccion = d.getIdDireccion();
		this.calle = d.getCalle();
		this.numero = d.getNumero();
		this.cp = d.getCp();
		this.municipio = d.getMunicipio();
		this.estado = d.getEstado();
		this.colonia = d.getColonia();
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
	
	

}
