package com.tiendaOnline.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tiendaOnline.dao.ClienteDao;
import com.tiendaOnline.model.ClienteEntity;
import com.tiendaOnline.model.RolEntity;



@Transactional
@Service
public class CustomUserDetailsService implements  UserDetailsService {

	@Autowired
	private ClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		ClienteEntity cliente = clienteDao.findByUsername(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (RolEntity rol : cliente.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(rol.getNombreRol()));
		}

		return new org.springframework.security.core.userdetails.User(cliente.getNombreUsuario(), cliente.getPassword(),
				grantedAuthorities);
	}
}
