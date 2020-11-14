package com.tienda.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name = "producto")
public class ProductoEntity implements Serializable {
	
	private static final long serialVersionUID =1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Long idProducto;
	
	private String producto;
	
	private Double precio;
	
	private String descripcion;
	
	private String imagen;
	
	@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
	@ManyToOne( cascade = CascadeType.ALL )
	private CategoriaEntity categoria;
	
	@OneToMany( mappedBy = "productoEntity", cascade = CascadeType.ALL )
	private List<PedidosProductoEntity> pedidosProducto;

	public ProductoEntity() {
	
	}
	
	public ProductoEntity(Long idProducto, String producto, Double precio, String descripcion, String imagen) {
		this.idProducto = idProducto;
		this.producto = producto;
		this.precio = precio;
		this.descripcion = descripcion;
		this.imagen = imagen;
	}

	public ProductoEntity(Long idProducto, String producto, Double precio, String descripcion, String imagen,
			CategoriaEntity categoria) {
		this.idProducto = idProducto;
		this.producto = producto;
		this.precio = precio;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.categoria = categoria;
	}

	public Long getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public CategoriaEntity getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaEntity categoria) {
		this.categoria = categoria;
	}
	
	
	public List<PedidosProductoEntity> getPedidosProducto() {
		return pedidosProducto;
	}

	public void setPedidosProducto(List<PedidosProductoEntity> pedidosProducto) {
		this.pedidosProducto = pedidosProducto;
	}


	@Override
	public String toString() {
		return "ProductoEntity [idProducto=" + idProducto + ", producto=" + producto + ", precio=" + precio
				+ ", descripcion=" + descripcion + ", imagen=" + imagen + ", categoria=" + categoria + "]";
	}
	
	

}
