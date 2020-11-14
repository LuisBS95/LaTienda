package com.tienda.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.entities.PedidosEntity;
import com.tienda.services.PedidosService;

@RestController
@RequestMapping("/pedidos")
public class PedidosController {
	
	@Autowired
	private PedidosService pedidosService;
	
	@GetMapping("/listar")
	public List<PedidosEntity> listarPedidos(){
		
		return pedidosService.encontraPedidos();
		
	}

}
