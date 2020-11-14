package com.tienda.repositories;




import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.tienda.dtos.Icombinada;
import com.tienda.entities.CategoriaEntity;
import com.tienda.entities.UsuarioEntity;

public interface CategoriaDao extends PagingAndSortingRepository<CategoriaEntity, Long> {
		
		@Query(value = "select * from categoria c where c.sub_categoria is null", nativeQuery = true)
		List<CategoriaEntity> findSuperCategorias();
		
		@Query(value = "select * from categoria c where c.sub_categoria = :id", nativeQuery = true)
		List<CategoriaEntity> findSubCategorias(@Param("id") Long id);

	
	

}
