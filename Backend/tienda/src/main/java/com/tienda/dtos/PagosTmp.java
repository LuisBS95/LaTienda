package com.tienda.dtos;

public class PagosTmp {

	private Long id;
	private Long numCliente;
	private String tipo;
	private Long txns;
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Long getTxns() {
		return txns;
	}
	public void setTxns(Long txns) {
		this.txns = txns;
	}
	
	
}
