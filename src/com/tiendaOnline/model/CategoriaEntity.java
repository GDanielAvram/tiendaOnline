package com.tiendaOnline.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Query;
@Entity
@Table(name = "Categoria")
public class CategoriaEntity {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idCategoria", nullable = false)
	private long idCategoria;
	
	public void setIdCategoria(long idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Column(name = "nombreCategoria")
	private String nombreCategoria;

	@OneToMany(fetch = FetchType.EAGER)
	/*@JoinTable(name = "Producto_Categoria", 
	joinColumns = @JoinColumn(name = "idCategoria"), 
	inverseJoinColumns = @JoinColumn(name = "idProducto"))*/
	private Set<ProductoEntity> productos= new HashSet<>();

	public long getIdCategoria() {
		return idCategoria;
	}



	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public Set<ProductoEntity> getProductos() {
		return productos;
	}

	public void setProductos(Set<ProductoEntity> productos) {
		this.productos = productos;
	}

	public boolean addProducto(ProductoEntity producto) {
		producto.setCategoria(this.nombreCategoria);
		return getProductos().add(producto);
	}

	public void removeProducto(ProductoEntity producto) {
		getProductos().remove(producto);
	}

}