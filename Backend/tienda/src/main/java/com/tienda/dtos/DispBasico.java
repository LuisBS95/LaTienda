package com.tienda.dtos;

import java.sql.Date;

public class DispBasico {

	private Long id;
	private Long numCliente;
	private Long numCuenta;
	private Long numContrato;
	private Long numProducto;
	private Long inst;
	private Long empleados;
	private Date falta;
	private Date fultmod;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNumCliente() {
		return numCliente;
	}
	public void setNumCliente(Long numCliente) {
		this.numCliente = numCliente;
	}
	public Long getNumCuenta() {
		return numCuenta;
	}
	public void setNumCuenta(Long numCuenta) {
		this.numCuenta = numCuenta;
	}
	public Long getNumContrato() {
		return numContrato;
	}
	public void setNumContrato(Long numContrato) {
		this.numContrato = numContrato;
	}
	public Long getNumProducto() {
		return numProducto;
	}
	public void setNumProducto(Long numProducto) {
		this.numProducto = numProducto;
	}
	public Long getInst() {
		return inst;
	}
	public void setInst(Long inst) {
		this.inst = inst;
	}
	public Long getEmpleados() {
		return empleados;
	}
	public void setEmpleados(Long empleados) {
		this.empleados = empleados;
	}
	public Date getFalta() {
		return falta;
	}
	public void setFalta(Date falta) {
		this.falta = falta;
	}
	public Date getFultmod() {
		return fultmod;
	}
	public void setFultmod(Date fultmod) {
		this.fultmod = fultmod;
	}
	
	
	
}
