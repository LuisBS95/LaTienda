package com.tienda.services;

import java.util.List;

import com.tienda.dtos.ProductosCat;
import com.tienda.entities.ProductoEntity;

public interface ProductoService {
	
	public List<ProductoEntity> encontrarProductos();
	public List<ProductosCat> encontrarProductosCat(Long id);

}
