package com.tienda.dtos;

public class SubCtaegoria {
	private Long idCategoria;
    private String categoria;
	private Long subCategoria;
	private Boolean tieneSubCategoria;
	public SubCtaegoria(Long idCategoria, String categoria, Long subCategoria, Boolean tieneSubCategoria) {	
		this.idCategoria = idCategoria;
		this.categoria = categoria;
		this.subCategoria = subCategoria;
		this.tieneSubCategoria = tieneSubCategoria;
	}
	
	public SubCtaegoria() {
		
	}

	public Long getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Long getSubCategoria() {
		return subCategoria;
	}
	public void setSubCategoria(Long subCategoria) {
		this.subCategoria = subCategoria;
	}
	public Boolean getTieneSubCategoria() {
		return tieneSubCategoria;
	}
	public void setTieneSubCategoria(Boolean tieneSubCategoria) {
		this.tieneSubCategoria = tieneSubCategoria;
	}
	
	
	
}
