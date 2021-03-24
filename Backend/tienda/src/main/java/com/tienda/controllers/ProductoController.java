package com.tienda.controllers;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.tienda.dtos.ChqsTmp;
import com.tienda.dtos.ListaTxt;
import com.tienda.dtos.PagosTmp;
import com.tienda.dtos.ProductosCat;
import com.tienda.dtos.Txt;
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
	
	@PostMapping("/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException{
		
		try {
			List<String> informacion = null;
			Map<String,List<String>> resultados = new HashMap<>(); 
			ServletContext c = request.getServletContext();
			String cadena = c.getRealPath("/");
			byte[] data = file.getBytes();
			ZipInputStream zip = new ZipInputStream(new ByteArrayInputStream(data));
			
			ZipEntry entry = null;
			while((entry = zip.getNextEntry()) != null) {
				Integer inicio = entry.getName().lastIndexOf("/") +1;
				Integer fin = entry.getName().lastIndexOf(".");
				String opcion = entry.getName().substring(inicio, fin);
				System.out.print("Nombre: "+entry.getName());
				
				//FileOutputStream fos = new FileOutputStream(cadena+entry.getName().substring(inicio,entry.getName().length()));
				
				int leer;
				byte[] buffer = new byte[1024];
				//List<byte> buffer = new ArrayList<>();
				while (0 < (leer = zip.read(buffer))) {
					//fos.write(buffer, 0, leer);
					informacion = new ArrayList<String>();
					//FileReader f = new FileReader(cadena+entry.getName().substring(inicio,entry.getName().length()));
					//BufferedReader b = new BufferedReader(f);
					BufferedReader b = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(buffer)),leer);
					while((cadena = b.readLine())!= null) {
						informacion.add(cadena);
					}
					
					resultados.put(opcion, informacion);
			
					b.close();
				}
				//fos.close();
				zip.closeEntry();
			}
			//ListaTxt lis = this.txtToObject(resultados);
			
			
			return new ResponseEntity<>(resultados,HttpStatus.OK);
		}catch (Exception e) {
			String error = e.getLocalizedMessage();
		}
		
		
		return null;
	}
	
	public ListaTxt txtToObject (Map<String, List<String>> csv){
		
		ListaTxt informacion = new ListaTxt();
		List<Txt> listaTxt = listaTxt = new ArrayList<>();; 
		Txt txt = null; 
		Long x = 0L;
		List<List<String>> separadas = null;
		for(List<String> lista : csv.values()) {
			
			separadas = new ArrayList<>();
			txt = new Txt();
			x = 0L;
			for(String linea : lista) {
				if(x != 0) {
					txt = new Txt();
					
					List<String> objeto =Arrays.asList(linea.split("\t"));
					separadas.add(objeto);
				}
				x++;
			}
			txt.setObjeto(separadas);
			Set<String> keys = csv.keySet();
//			for(String key : keys) {
//				
//			}
			listaTxt.add(txt);
		}
		 
		informacion.setTxt(listaTxt);
		//for(String linea : csv.values())
		return informacion;
	}
	
	public List<PagosTmp> txtToObjectCheques(List<String> csv){
		
		List<PagosTmp> datos = new ArrayList<>();
		Long x = 0L;
		
		for(String linea: csv) {
			if(x!=0) {
				double  valor;
				int a;
				String[] lin = linea.split("\t");
				PagosTmp pagos = new PagosTmp();
				pagos.setId(x);
				pagos.setNumCliente(Long.parseLong(lin[0]));
				pagos.setTipo(lin[1]);
				pagos.setTxns(Long.parseLong(lin[2]));
				
				datos.add(pagos);
			}
			x++;
		}
		
		return datos;
	}
	
//	@PostMapping("/upload")
//	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException{
//		
//		try {
//			List<String> informacion = null;
//			ServletContext c = request.getServletContext();
//			String cadena = c.getRealPath("/");
//			byte[] data = file.getBytes();
//			ZipInputStream zip = new ZipInputStream(new ByteArrayInputStream(data));
//			
//			ZipEntry entry = null;
//			while((entry = zip.getNextEntry()) != null) {
//				String opcion = entry.getName();
//				System.out.print("Nombre: "+entry.getName());
//				Integer inicio = entry.getName().lastIndexOf("/")+1;
//				FileOutputStream fos = new FileOutputStream("C:\\Users\\User\\OneDrive\\Escritorio\\Nueva carpeta\\"+entry.getName().substring(inicio,entry.getName().length()));
//				
////				FileReader reader = new FileReader();
////				BufferedReader bufRead = new BufferedReader(reader);
//				int leer;
//				byte[] buffer = new byte[1024];
//				while (0 < (leer = zip.read(buffer))) {
//					fos.write(buffer, 0, leer);
//					String cad ="";
//					informacion = new ArrayList<String>();
//					FileReader f = new FileReader("C:\\Users\\User\\OneDrive\\Escritorio\\Nueva carpeta\\"+entry.getName().substring(inicio,entry.getName().length()));
//					BufferedReader b = new BufferedReader(f);
//					while((cadena = b.readLine())!= null) {
//						informacion.add(cadena);
//					}
//					
//					switch(opcion) {
//					case "BASICO/PAGOS_BASICO_201907.txt":
//						List<PagosTmp> datos = this.txtToObjectCheques(informacion);
//						break;
//					default:
//						break;
//					}
//					b.close();
//				}
//				fos.close();
//				zip.closeEntry();
//			}
//		}catch (Exception e) {
//			String error = e.getLocalizedMessage();
//		}
//		
//		
//		return null;
//	}
//	
//	
//	public List<PagosTmp> txtToObjectCheques(List<String> csv){
//		
//		List<PagosTmp> datos = new ArrayList<>();
//		Long x = 0L;
//		
//		for(String linea: csv) {
//			if(x!=0) {
//				double  valor;
//				int a;
//				String[] lin = linea.split("\t");
//				PagosTmp pagos = new PagosTmp();
//				pagos.setId(x);
//				pagos.setNumCliente(Long.parseLong(lin[0]));
//				pagos.setTipo(lin[1]);
//				pagos.setTxns(Long.parseLong(lin[2]));
//				
//				datos.add(pagos);
//			}
//			x++;
//		}
//		
//		return datos;
//	}
	
	
	
//	public ResponseEntity<?> descomprimir( ZipInputStream zip){
//		int Buffer_size = 8192;
//		List<String> informacion = new ArrayList<String>();
//		BufferedOutputStream bos = null;
//		FileInputStream fis = null;
//		ZipInputStream zipis = null;
//		FileOutputStream fos = null;
//		
//		try {
//			zipis = zip;
//			if(zipis.getNextEntry() != null) {
//				int len = 0;
//				byte[] buffer = new byte[Buffer_size];
//	
//			}
//		}catch (Exception e) {
//			String error = e.getLocalizedMessage();
//		}
//		return null;
//	}
//	
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
