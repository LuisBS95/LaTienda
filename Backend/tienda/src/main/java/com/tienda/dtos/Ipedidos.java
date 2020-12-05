package com.tienda.dtos;

import java.util.Date;

import lombok.Getter;
@Getter
public interface Ipedidos {
	
	
	Long getIdpedido();
	
	Long getIdUsuario();	
	
	Date  getFechapedido();
	
    Date getFechaProgramada();
	
    Date getFechaEntregaReal();
	
	Double getCostoTotal();

}
