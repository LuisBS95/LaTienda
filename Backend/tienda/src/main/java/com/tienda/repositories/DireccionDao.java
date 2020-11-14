package com.tienda.repositories;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.tienda.entities.DireccionEntity;

public interface DireccionDao extends PagingAndSortingRepository<DireccionEntity, Long>{

}
