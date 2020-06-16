package com.tiendaOnline.dao;

import java.util.List;

import com.tiendaOnline.model.CategoriaEntity;

public interface CategoriaDao extends GenericDao<CategoriaEntity>{
	
	public List<CategoriaEntity> findAll();
	public CategoriaEntity findByid(long id);
	public List<CategoriaEntity> findByNombre(String nombreCategoria);

}
