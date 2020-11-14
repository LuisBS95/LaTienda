package com.tienda.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


import lombok.Data;

@Entity
@Data
@Table(name = "categoria")
public class CategoriaEntity implements Serializable {
	
	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Long idCategoria;
	
	private String categoria;
	
	@Column(name = "sub_categoria")
	private Long subCategoria;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL )
	private List<ProductoEntity> productos;

	
	public CategoriaEntity() {

	}
	
	public CategoriaEntity(Long idCategoria) {
		this.idCategoria = idCategoria;

	}
	
	public CategoriaEntity(Long idCategoria, String categoria, Long subCategoria) {
		this.idCategoria = idCategoria;
		this.categoria = categoria;
		this.subCategoria = subCategoria;
	}
	
	public CategoriaEntity(Long idCategoria, String categoria, Long subCategoria, List<ProductoEntity> productos) {
		
		this.idCategoria = idCategoria;
		this.categoria = categoria;
		this.subCategoria = subCategoria;
		this.productos = productos;
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

	public List<ProductoEntity> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoEntity> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "CategoriaEntity [idCategoria=" + idCategoria + ", categoria=" + categoria + ", subCategoria="
				+ subCategoria + "]";
	}


	
	
	
}
