package com.tiendaOnline.service;

import java.util.List;

import javax.validation.Valid;

import com.tiendaOnline.dto.ProductoDto;
import com.tiendaOnline.model.ProductoEntity;

public interface ProductoEntityService {
	
	public ProductoEntity crearProducto(ProductoEntity p, String nombreCategoria);
	
	public ProductoEntity create(ProductoEntity t);
	
	public List<ProductoEntity> obtenerProductos();
	
	public ProductoEntity obtenerProductoPorNombre(String nombreProducto);
	
	public ProductoEntity obtenerProductoPorId(long idProducto);
	
	public void borrarProducto(long idProducto);
	public void delete(long id);
	
	public ProductoEntity comprobarEdicionProducto(ProductoEntity prod, String nombreProducto, String precio, String stock, String categoria);

	public ProductoEntity update(ProductoEntity producto);

	public List<ProductoDto> listarProductoPorNombre(String nombreProducto);
	
	public List<ProductoDto> findByName(String id);
}
