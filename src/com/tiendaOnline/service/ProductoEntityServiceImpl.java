package com.tiendaOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiendaOnline.dao.CategoriaDao;
import com.tiendaOnline.dao.ProductoDao;
import com.tiendaOnline.dto.ProductoDto;
import com.tiendaOnline.model.CategoriaEntity;
import com.tiendaOnline.model.ProductoEntity;



@Transactional
@Service
public class ProductoEntityServiceImpl implements ProductoEntityService {
	
	@Autowired
	private ProductoDao productoDao;
	
	@Autowired
	private CategoriaDao categoriaDao;

	public ProductoEntity crearProducto(ProductoEntity p,String nombreCategoria) {
		
		CategoriaEntity cat = new CategoriaEntity();
        List<CategoriaEntity> lista = categoriaDao.findByNombre(nombreCategoria);
        for(CategoriaEntity l: lista) {
        	if(l.getNombreCategoria().equals(nombreCategoria)) {
        		cat = l;
        	}
        }
        
        cat.addProducto(p);
        this.categoriaDao.update(cat);
        this.productoDao.create(p); 
	return p;}
	
	@Override
	public void borrarProducto(long idProducto) {
		productoDao.delete(idProducto);
	}
	
	public void BorrarProductoBase(long idProducto) {
		ProductoEntity prod = this.productoDao.buscarProductoPorId(idProducto);
		String cat = prod.getCategoria();
		CategoriaEntity categoria = null;
		List<CategoriaEntity> lista = this.categoriaDao.findByNombre(cat);
        for(CategoriaEntity l: lista) {
        	if(l.getNombreCategoria().equals(cat)){
        		categoria = l;
        	}
        }
		this.productoDao.delete(idProducto);
		if(categoria != null) {
			categoria.removeProducto(prod);
			categoriaDao.update(categoria);
		}		
	}
	
	@Override
	public List<ProductoEntity> obtenerProductos() {
		return productoDao.listarProductos();
	}
	@Override
	public ProductoEntity obtenerProductoPorNombre(String nombreProducto) {
		return productoDao.buscarProductoPorNombre(nombreProducto);
	}

	@Override
	public ProductoEntity obtenerProductoPorId(long idProducto) {
		return productoDao.buscarProductoPorId(idProducto);
	}
	
	@Override
	public ProductoEntity comprobarEdicionProducto(ProductoEntity prod, String nombreProducto, String precio, String stock, String categoria) {
		return this.productoDao.comprobarEdicionProducto(prod, nombreProducto, precio, stock, categoria);
	}

	@Override
	public ProductoEntity create(ProductoEntity t) {
		// TODO Auto-generated method stub
		return this.productoDao.create(t);
	}

	@Override
	public void delete(long id) {
		this.productoDao.deleteProducto(id);
		
	}

	@Override
	public ProductoEntity update(ProductoEntity producto) {
		return this.productoDao.update(producto);
		
	}

	@Override
	public List<ProductoDto> findByName(String id) {
		return this.productoDao.findByName(id);
	}

	@Override
	public List<ProductoDto> listarProductoPorNombre(String nombreProducto) {
		// TODO Auto-generated method stub
		return null;
	}
}
