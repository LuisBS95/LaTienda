package com.tienda.entities;


import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "pedidos_producto")
public class PedidosProductoEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pp")
	private Long idPp;
	
	
	@JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido" )
	@ManyToOne(cascade = CascadeType.ALL )
	private PedidosEntity pedidosEntity;
	
	@JoinColumn(name = "id_producto", referencedColumnName = "id_producto" )
	@ManyToOne(cascade = CascadeType.ALL )
	private ProductoEntity productoEntity;
//	
	private Long cantidad;

	public PedidosProductoEntity(PedidosEntity pedidosEntity, ProductoEntity productoEntity, Long cantidad) {
		this.pedidosEntity = pedidosEntity;
		this.productoEntity = productoEntity;
		this.cantidad = cantidad;
	}
	
	public PedidosProductoEntity(Long cantidad) {
		this.cantidad = cantidad;
	}
	
	public PedidosProductoEntity() {
	
	}

	@Override
	public String toString() {
		return "PedidosProductoEntity [pedidosEntity=" + pedidosEntity + ", productoEntity=" + productoEntity
				+ ", cantidad=" + cantidad + "]";
	}
	
	
	
	
	
}
