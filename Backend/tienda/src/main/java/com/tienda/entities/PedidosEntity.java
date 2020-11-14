package com.tienda.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "pedidos")
public class PedidosEntity implements Serializable{

	private static final long serialVersionUID =1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long idpedido;
	
	@Column(name = "fecha_pedido")
	private Date fechapedido;
	
	@Column(name = "fecha_programada")
	private Date fechaProgramada;
	
	@Column(name = "fecha_entrega_real")
	private Date fechaEntregaReal;
	
	@Column(name = "costo_total")
	private Double costoTotal;
//	
	@JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario" )
	@ManyToOne(cascade = CascadeType.ALL )
	private UsuarioEntity usuarioEntity;
//	
	@OneToMany( mappedBy = "pedidosEntity", cascade = CascadeType.ALL )
	private List<PedidosProductoEntity> pedidosProducto;

	
	
	public PedidosEntity() {

	}
	
	public PedidosEntity(Long idpedido) {
		this.idpedido = idpedido;
	}
	
	public PedidosEntity(Long idpedido, Date fechapedido, Date fechaProgramada, Date fechaEntregaReal,
			Double costoTotal) {
		this.idpedido = idpedido;
		this.fechapedido = fechapedido;
		this.fechaProgramada = fechaProgramada;
		this.fechaEntregaReal = fechaEntregaReal;
		this.costoTotal = costoTotal;

	}
	
	public PedidosEntity(Long idpedido, Date fechapedido, Date fechaProgramada, Date fechaEntregaReal,
			Double costoTotal, UsuarioEntity usuarioEntity, List<PedidosProductoEntity> pedidosProducto) {
		this.idpedido = idpedido;
		this.fechapedido = fechapedido;
		this.fechaProgramada = fechaProgramada;
		this.fechaEntregaReal = fechaEntregaReal;
		this.costoTotal = costoTotal;
		this.usuarioEntity = usuarioEntity;
		this.pedidosProducto = pedidosProducto;
	}

	public Long getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(Long idpedido) {
		this.idpedido = idpedido;
	}

	public Date getFechapedido() {
		return fechapedido;
	}

	public void setFechapedido(Date fechapedido) {
		this.fechapedido = fechapedido;
	}

	public Date getFechaProgramada() {
		return fechaProgramada;
	}

	public void setFechaProgramada(Date fechaProgramada) {
		this.fechaProgramada = fechaProgramada;
	}

	public Date getFechaEntregaReal() {
		return fechaEntregaReal;
	}

	public void setFechaEntregaReal(Date fechaEntregaReal) {
		this.fechaEntregaReal = fechaEntregaReal;
	}

	public Double getCostoTotal() {
		return costoTotal;
	}

	public void setCostoTotal(Double costoTotal) {
		this.costoTotal = costoTotal;
	}
//
	public UsuarioEntity getUsuarioEntity() {
		return usuarioEntity;
	}

	public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
		this.usuarioEntity = usuarioEntity;
	}

	public List<PedidosProductoEntity> getPedidosProducto() {
		return pedidosProducto;
	}

	public void setPedidosProducto(List<PedidosProductoEntity> pedidosProducto) {
		this.pedidosProducto = pedidosProducto;
	}

	@Override
	public String toString() {
		return "PedidosEntity [idpedido=" + idpedido + ", fechapedido=" + fechapedido + ", fechaProgramada="
				+ fechaProgramada + ", fechaEntregaReal=" + fechaEntregaReal + ", costoTotal=" + costoTotal + "]";
	}
	
	
	
}
