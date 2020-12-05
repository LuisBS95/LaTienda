package com.tienda.dtos;
import lombok.Getter;

@Getter
public interface IProdPedCat {

	Long getIdProducto();
	String getProducto();
	Double getPrecio();
	String getDescripcion();
	String getCategoria();
	Long getCantidad();
	Double getCostoTotal();

}
