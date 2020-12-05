package com.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.tienda.dtos.Combinada;
import com.tienda.dtos.IProdPedCat;
import com.tienda.dtos.Icombinada;
import com.tienda.dtos.Ipedidos;
import com.tienda.entities.UsuarioEntity;

public interface UsuarioDao extends PagingAndSortingRepository<UsuarioEntity, Long> {
	
	@Query(value = "select u.nombre as nombre,u.apellido as apellido,d.calle as calle,d.numero as numero from usuario u join direccion d", nativeQuery = true)
	List<Icombinada> findCom();
	
	@Query(value="select u.email as email from usuario u where u.email like :email ",nativeQuery=true)
	List<String> findbyEmail(@Param("email") String email);

	@Query(value = "select p.id_pedido as idpedido, p.id_usuario as idUsuario, p.fecha_pedido as fechapedido, p.fecha_programada as fechaProgramada,"
			+ " p.fecha_entrega_real as fechaEntregaReal, p.costo_total as costoTotal  from  pedidos p where p.id_usuario = :id ", nativeQuery = true)
	List<Ipedidos> findPedidos(@Param("id") Long id);
	
	@Query(value = "SELECT pr.id_producto as idProducto, pr.producto as producto, pr.precio as precio,"
			+ " pr.descripcion as descripcion, c.categoria as categoria,"
			+ " pp.cantidad as cantidad, p.costo_total as costoTotal "
			+ " FROM usuario u"
			+ " LEFT JOIN pedidos p ON u.id_usuario = p.id_usuario "
			+ " LEFT JOIN pedidos_producto pp   ON pp.id_pedido= p.id_pedido"
			+ " LEFT JOIN producto pr ON pr.id_producto = pp.id_producto"
			+ " LEFT JOIN categoria c ON pr.id_categoria = c.id_categoria"
			+ " where p.id_pedido = :idPedido ", nativeQuery = true)
	List<IProdPedCat> findProductos(@Param("idPedido") Long idPedido);
}
