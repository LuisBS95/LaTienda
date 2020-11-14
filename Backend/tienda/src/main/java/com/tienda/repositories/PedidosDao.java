package com.tienda.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.tienda.entities.PedidosEntity;

public interface PedidosDao extends PagingAndSortingRepository<PedidosEntity, Long> {

}
