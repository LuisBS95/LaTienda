package com.tienda.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.dtos.SubCtaegoria;
import com.tienda.entities.CategoriaEntity;
import com.tienda.repositories.CategoriaDao;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaDao categoriaDao;
	
	@Override
	public List<CategoriaEntity> encontraCategorias() {
		
		List<CategoriaEntity> listaCategorias = (List<CategoriaEntity>) categoriaDao.findAll();
//		for(CategoriaEntity catego : listaCategorias) {
//			categotoDTO(catego);
//		}
	
		return listaCategorias;
	}
	
	@Override
	public List <CategoriaEntity> SuperCategorias(){
		return (List<CategoriaEntity>) categoriaDao.findSuperCategorias();
	}
	
	@Override
	public List <CategoriaEntity> SubCategorias(Long id){
		return (List<CategoriaEntity>) categoriaDao.findSubCategorias(id);
	}

	@Override
	public List<SubCtaegoria> EncontrarSubcategoria() {
		List<CategoriaEntity> categorias = (List<CategoriaEntity>) categoriaDao.findSuperCategorias();
		List<SubCtaegoria> subCategos = new ArrayList<>();
		
		categorias.forEach(catego -> {
			SubCtaegoria subCatego = new SubCtaegoria();
			subCatego.setIdCategoria(catego.getIdCategoria());
			subCatego.setCategoria(catego.getCategoria());
			subCatego.setSubCategoria(catego.getSubCategoria());
			if(categoriaDao.findSubCategorias(catego.getIdCategoria()).isEmpty()) {
				subCatego.setTieneSubCategoria(false);
			}else {
				subCatego.setTieneSubCategoria(true);
			}
			subCategos.add(subCatego);
		});
		return subCategos;
	}
	



}
