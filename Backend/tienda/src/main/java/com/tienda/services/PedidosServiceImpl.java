package com.tienda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.entities.PedidosEntity;
import com.tienda.repositories.PedidosDao;

@Service
public class PedidosServiceImpl implements PedidosService {
	
	@Autowired
	private PedidosDao pedidosDao;
	
	@Override
	public List<PedidosEntity> encontraPedidos() {
		
		return (List<PedidosEntity>) pedidosDao.findAll();
	}

}
