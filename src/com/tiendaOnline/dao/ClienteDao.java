package com.tiendaOnline.dao;

import com.tiendaOnline.model.ClienteEntity;


public interface ClienteDao extends GenericDao<ClienteEntity>{
	
	public ClienteEntity autenticarUsuario(String usuario, String contraseña);

	public ClienteEntity findByUsername(String username);
	
//	public ClienteEntity buscarPorEmail (String email);
//	
//	public List<ClienteEntity> buscarPorfesorPorNombreYApellidos(String nombreyapellidos);
//	
//	public List<ClienteEntity> listarClientes();

}

//Autenticar user,pasw
//Mostrar prod
//Crear prod
//Eliminar prod
//Log out
//perfil usuario