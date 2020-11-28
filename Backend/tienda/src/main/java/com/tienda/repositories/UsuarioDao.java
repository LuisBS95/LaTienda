package com.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.tienda.dtos.Combinada;
import com.tienda.dtos.Icombinada;
import com.tienda.entities.UsuarioEntity;

public interface UsuarioDao extends PagingAndSortingRepository<UsuarioEntity, Long> {
	
	@Query(value = "select u.nombre as nombre,u.apellido as apellido,d.calle as calle,d.numero as numero from usuario u join direccion d", nativeQuery = true)
	List<Icombinada> findCom();
	
	@Query(value="select u.email as email from usuario u where u.email like :email ",nativeQuery=true)
	List<String> findbyEmail(@Param("email") String email);

}
