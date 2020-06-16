package com.tiendaOnline.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tiendaOnline.dao.ClienteDao;
import com.tiendaOnline.model.ClienteEntity;

@Transactional
@Service
public class ClienteEntityServiceImpl implements ClienteEntityService{
	
	@Autowired
	private ClienteDao clienteDao;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public ClienteEntity autenticarUsuario(String usuario, String contraseña) {
		return clienteDao.autenticarUsuario(usuario, contraseña);
	}

	@Override
	public ClienteEntity findByUsername(String username) {
		return clienteDao.findByUsername(username);
	}

	@Override
	public ClienteEntity create(ClienteEntity clienteEntity) {
		clienteEntity.setPassword(bCryptPasswordEncoder.encode(clienteEntity.getPassword()));
		return clienteDao.create(clienteEntity);
	}
}
