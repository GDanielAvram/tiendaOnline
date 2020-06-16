package com.tiendaOnline.dao;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.modelmapper.ModelMapper;

import com.tiendaOnline.dto.ProductoDto;
import com.tiendaOnline.model.ProductoEntity;

@Repository
@Component("ProductoDao")
public class ProductoDaoImpl extends GenericDaoImpl<ProductoEntity> implements ProductoDao {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ProductoEntity buscarProductoPorNombre(String nombreProducto) {
		Query query = this.em
                .createQuery("select u FROM ProductoEntity u where u.nombreProducto= :nombreProducto");
        query.setParameter("nombreProducto", "%"+nombreProducto+"%");
        ProductoEntity producto = (ProductoEntity) query.getSingleResult();
        
        if (producto != null ) {
            return producto;
        }
		return null;
	}

	@Override
	public List<ProductoEntity> listarProductos() {
		Query query = this.em
                .createQuery("FROM ProductoEntity p");
        List<ProductoEntity> lProducto = query.getResultList();
        
        if (lProducto != null ) {
            return lProducto;
        }
		return null;
	}

	@Override
	public ProductoEntity buscarProductoPorId(long idProducto) {
		Query query = this.em
                .createQuery("select u FROM ProductoEntity u where u.idProducto= :idProducto");
        query.setParameter("idProducto", idProducto);
        ProductoEntity producto = (ProductoEntity) query.getSingleResult();
        
        if (producto != null ) {
            return producto;
        }
		return null;
	}

	@Override
	public ProductoEntity comprobarEdicionProducto(ProductoEntity prod, String nombreProducto, String precio, String stock, String categoria) {
		//Si no cambian nada se quedan como estan 
		if(nombreProducto=="") {       
	        }else {
	        	prod.setNombreProducto(nombreProducto);
	        }
	        if(precio=="") {
	        }else {
	        	 prod.setPrecio(Double.parseDouble(precio));
	        } 
	        if(stock=="") {
	        }else {
	        	prod.setStock(Integer.parseInt(stock));
	        }		        
	       return prod;
	}
	
	@Override
	@Transactional
	public ProductoEntity create(ProductoEntity producto) {

       this.em.persist(producto);
       this.em.flush();
       
        
		return producto;
	}

	@Override
	public void deleteProducto(long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<ProductoDto> findByName(String nom) {

        String nym = "%" + nom + "%";
        Query query = this.em.createQuery("FROM ProductoEntity p WHERE p.nombreProducto LIKE :nym");
        query.setParameter("nym", nym);
        List<ProductoEntity> lProducto = query.getResultList();

        if (lProducto == null) {
            System.out.println("No hay productos.");
            return null;

        }
        System.out.println("Se ejecuta y hay " + lProducto.size() + " productos.");
        return lProducto.stream()
                  .map(this::convertToProductoDto)
                  .collect(Collectors.toList());
	}
	private ProductoDto convertToProductoDto(ProductoEntity producto) {
        ProductoDto productoDto = modelMapper.map(producto, ProductoDto.class);
        return productoDto;
    }

}
