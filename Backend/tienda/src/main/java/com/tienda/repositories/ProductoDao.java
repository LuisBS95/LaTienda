package com.tienda.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import com.tienda.dtos.ProductosCat;
import com.tienda.entities.ProductoEntity;

public interface ProductoDao extends PagingAndSortingRepository<ProductoEntity, Long> {
	
@Query(value = "select p.id_producto as idProducto, p.producto as producto, p.precio as precio, p.descripcion as descripcion, p.imagen as imagen, c.categoria as categoria from producto p inner join categoria c on p.id_categoria = c.id_categoria where c.id_categoria = :idCat Limit 6",nativeQuery= true)
List <ProductosCat> findProductosCat (@Param("idCat") Long idCat);

@Query(value = "select p.id_producto as idProducto, p.producto as producto, p.precio as precio, p.descripcion as descripcion, p.imagen as imagen, c.categoria as categoria from producto p inner join categoria c on p.id_categoria = c.id_categoria where c.id_categoria = :idCat",nativeQuery= true)
List <ProductosCat> findProductosCatLimitless (@Param("idCat") Long idCat);

@Query(value = "select p.id_producto as idProducto, p.producto as producto, p.precio as precio, p.descripcion as descripcion, p.imagen as imagen, c.categoria as categoria from producto p inner join categoria c on p.id_categoria = c.id_categoria where p.id_producto = :id",nativeQuery= true)
ProductosCat findProductosById (@Param("id") Long id);

}
