package com.tiendaOnline.service;

import java.util.List;

import com.tiendaOnline.model.CategoriaEntity;



public interface CategoriaEntityService {
	public List<CategoriaEntity> findAll();
	public CategoriaEntity findByid(long id);
	public CategoriaEntity create(CategoriaEntity t);
    public CategoriaEntity update(CategoriaEntity categoria);
	public void delete(long id);
}
