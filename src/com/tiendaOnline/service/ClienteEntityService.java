package com.tiendaOnline.service;

import com.tiendaOnline.model.ClienteEntity;

public interface ClienteEntityService {
	public ClienteEntity autenticarUsuario(String usuario, String contrase�a);
	
	public ClienteEntity findByUsername(String username);
	
	public ClienteEntity create(ClienteEntity clienteEntity);
	
}
