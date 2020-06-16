package com.tiendaOnline.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tiendaOnline.dao.CategoriaDao;
import com.tiendaOnline.model.CategoriaEntity;

@Transactional
@Service
public class CategoriaEntityServiceImpl implements CategoriaEntityService{
	
	@Autowired
	private CategoriaDao categoriaDao;

	@Override
	public List<CategoriaEntity> findAll() {
		// TODO Auto-generated method stub
		return this.categoriaDao.findAll();
	}

	@Override
	public CategoriaEntity findByid(long id) {
		// TODO Auto-generated method stub
		return this.categoriaDao.findByid(id);
	}

	@Override
	public CategoriaEntity create(CategoriaEntity t) {
		// TODO Auto-generated method stub
		return this.categoriaDao.create(t);
	}

	@Override
	public CategoriaEntity update(CategoriaEntity Categoria) {
		// TODO Auto-generated method stub
		return this.categoriaDao.update(Categoria);
	}

	@Override
	public void delete(long id) {
		this.categoriaDao.delete(id);
		
	}
	
}
