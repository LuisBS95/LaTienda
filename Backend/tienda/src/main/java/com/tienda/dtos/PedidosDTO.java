package com.tienda.dtos;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.tienda.entities.PedidosEntity;
import com.tienda.entities.PedidosProductoEntity;
import com.tienda.entities.UsuarioEntity;

public class PedidosDTO {
	
	@Autowired 
	private PedidosEntity p;

	private Long idpedido;
	private Date fechapedido;
	private Date fechaProgramada;
	private Date fechaEntregaReal;
	private Double costoTotal;	
	private UsuarioEntity usuario;
	private List<PedidosProductoEntity> pedidosProductoDAO;
	
	
	public PedidosDTO(PedidosEntity p) {
		this.idpedido = p.getIdpedido();
		this.fechapedido = p.getFechapedido();
		this.fechaProgramada = p.getFechaProgramada();
		this.fechaEntregaReal = p.getFechaEntregaReal();
		this.costoTotal = p.getCostoTotal();
		this.usuario = p.getUsuarioEntity();
		this.pedidosProductoDAO = p.getPedidosProducto();
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


	public UsuarioEntity getUsuario() {
		return usuario;
	}


	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}


	public List<PedidosProductoEntity> getPedidosProductoDAO() {
		return pedidosProductoDAO;
	}


	public void setPedidosProductoDAO(List<PedidosProductoEntity> pedidosProductoDAO) {
		this.pedidosProductoDAO = pedidosProductoDAO;
	}


	
	
	
	
	
	
}
