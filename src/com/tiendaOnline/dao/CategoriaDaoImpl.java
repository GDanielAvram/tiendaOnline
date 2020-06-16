package com.tiendaOnline.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tiendaOnline.model.CategoriaEntity;

@Repository
@Component("CategoriaDaoImpl")
public class CategoriaDaoImpl extends GenericDaoImpl<CategoriaEntity> implements CategoriaDao{
	
	@Autowired
	private RolRepository rolRepository;

	public List<CategoriaEntity> findAll() {
		Query query = this.em.createQuery("FROM CategoriaEntity c");
        List<CategoriaEntity> lCat =  query.getResultList();
        
        if (lCat == null ) {
            return null;
        }
		return lCat;
	}
	public CategoriaEntity findByid(long id) {
		Query query = this.em.createQuery("FROM CategoriaEntity u WHERE u.idCategoria=:id");
		query.setParameter("id", id);
        CategoriaEntity lCat =  (CategoriaEntity) query.getSingleResult();
        
        if (lCat == null ) {
            return null;
        }
		return lCat;
	}
	@Override
	public List<CategoriaEntity> findByNombre(String nombreCategoria) {
		Query query = this.em.createQuery("FROM CategoriaEntity u WHERE u.nombreCategoria LIKE :id");
		query.setParameter("id", "%"+nombreCategoria+"%");
		List<CategoriaEntity> lCat =  query.getResultList();
                
        if (lCat == null ) {
            return null;
        }
		return lCat;
	}

}
