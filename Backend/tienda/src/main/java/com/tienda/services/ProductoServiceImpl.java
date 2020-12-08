package com.tienda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.dtos.ProductosCat;
import com.tienda.entities.ProductoEntity;
import com.tienda.repositories.ProductoDao;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDao productoDao;
	
	@Override
	public List<ProductoEntity> encontrarProductos() {
		return (List<ProductoEntity>) productoDao.findAll();
	}

	@Override
	public List<ProductosCat> encontrarProductosCat(Long id) {
		
		return productoDao.findProductosCat(id);
	}

	@Override
	public List<ProductosCat> encontrarProductosCatSinLimites(Long id) {
		
		return productoDao.findProductosCatLimitless(id);
	}

	@Override
	public ProductosCat encontrarProductoPorId(Long Id) {
	
		return productoDao.findProductosById(Id);
	}
	
	

}
