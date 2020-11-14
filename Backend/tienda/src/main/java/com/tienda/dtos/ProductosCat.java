package com.tienda.dtos;

import lombok.Getter;

@Getter
public interface ProductosCat {
	
	Long getIdProducto();
	String getProducto();
	Double getPrecio();
	String getDescripcion();
	String getImagen();
	String getCategoria();
	}
