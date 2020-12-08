package com.tienda.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.dtos.ProductosCat;
import com.tienda.entities.ProductoEntity;
import com.tienda.services.ProductoService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/producto")


public class ProductoController {

	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/listar/{id}") 
	public List<ProductosCat> listarProducto(@PathVariable Long id ){
		
		return productoService.encontrarProductosCat(id);
	}
	
	@GetMapping("/listarsl/{id}") 
	public List<ProductosCat> listarProductosl(@PathVariable Long id ){
		
		return productoService.encontrarProductosCatSinLimites(id);
	}
	
	@GetMapping("/carrito/{id}")
	public ProductosCat Producto(@PathVariable Long id) {
		return productoService.encontrarProductoPorId(id);
	}
	
}
