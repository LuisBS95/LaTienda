package com.tienda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.entities.DireccionEntity;
import com.tienda.repositories.DireccionDao;

@Service
public class DireccionServiceImpl implements DireccionService {

	@Autowired
	private DireccionDao direccionDao;
	
	@Override
	public List<DireccionEntity> encontraDirecciones() {
		// TODO Auto-generated method stub
		return (List<DireccionEntity>) direccionDao.findAll();
	}

	
}
