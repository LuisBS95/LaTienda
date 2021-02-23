package com.tienda.controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

//	
//	@Autowired
//	private ProductoService productoService;
//	
//	@GetMapping("/listar/{id}") 
//	public List<ProductosCat> listarProducto(@PathVariable Long id ){
//		
//		return productoService.encontrarProductosCat(id);
//	}
//	
//	@GetMapping("/listarsl/{id}") 
//	public List<ProductosCat> listarProductosl(@PathVariable Long id ){
//		
//		return productoService.encontrarProductosCatSinLimites(id);
//	}
//	
//	@GetMapping("/carrito/{id}")
//	public ProductosCat Producto(@PathVariable Long id) {
//		return productoService.encontrarProductoPorId(id);
//	}
	
	@GetMapping("/folio/{max}")
	public String getFolio(@PathVariable(name = "max") String max) {
		String newFolio ="";
		SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
		
		try {
			String hoy = formato.format(new Date());
			
			String lastF = max.substring(0,8);
			if(!hoy.equals(lastF)) {
				newFolio = hoy + "01";
			}else {
				Long suma = Long.parseLong(max) + 1L;
				newFolio = suma.toString();
				
			}
			return newFolio;
		}catch (Exception e) {
			
			return e.getLocalizedMessage();
		}
		
	}
	
//	@GetMapping("hora/{a}")
//	public String ponerhora(@PathVariable String a) throws ParseException {		
//		SimpleDateFormat forma = new SimpleDateFormat("dd-MM-yyyy");
//		
//		Date hoy = new Date();
//		String hoy1=forma.format(hoy);
//		
//		SimpleDateFormat forma2 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
//		
//		String nueva = hoy1 + " "+a;
//		hoy= forma2.parse(nueva);
//		String f=forma2.format(hoy);
//		return hoy.toString() +"    otro estilo:    "+ f  ;
//	}
}
