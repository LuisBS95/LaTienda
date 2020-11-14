package com.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tienda.dtos.Combinada;
import com.tienda.dtos.Icombinada;
import com.tienda.entities.UsuarioEntity;

public interface UsuarioDao extends PagingAndSortingRepository<UsuarioEntity, Long> {
	
	@Query(value = "select u.nombre as nombre,u.apellido as apellido,d.calle as calle,d.numero as numero from usuario u join direccion d", nativeQuery = true)
	List<Icombinada> findCom();

}
