package com.tiendaOnline.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.tiendaOnline.dto.ProductoDto;
import com.tiendaOnline.model.ProductoEntity;

public interface ProductoDao extends GenericDao<ProductoEntity>{

	public List<ProductoEntity> listarProductos();
	
	public ProductoEntity buscarProductoPorNombre(String nombreProducto);
	
	public ProductoEntity buscarProductoPorId(long idProducto);

	public ProductoEntity comprobarEdicionProducto(ProductoEntity prod, String nombreProducto, String precio,
			String stock, String categoria);
	
	@Modifying
	public ProductoEntity create(ProductoEntity producto);
	
	@Modifying
	@Query("UPDATE producto SET stock = :stock where idProducto = :id")
	ProductoEntity update(ProductoEntity ProductoEntity);
	
	@Modifying
	@Query("DELETE FROM producto WHERE idProducto=:id")
	public void deleteProducto(long id);

	List<ProductoDto> findByName(String nom);
}
