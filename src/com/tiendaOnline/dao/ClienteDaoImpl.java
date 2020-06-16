package com.tiendaOnline.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tiendaOnline.model.ClienteEntity;
import com.tiendaOnline.model.RolEntity;

@Repository
@Component("ClienteDaoImpl")
public class ClienteDaoImpl extends GenericDaoImpl<ClienteEntity> implements ClienteDao {
	
	@Autowired
	private RolRepository rolRepository;
	
	@Override
	public ClienteEntity autenticarUsuario(String usuario, String contraseña) {
		Query query = this.em.createQuery("FROM ClienteEntity u WHERE u.nombreUsuario= :usuario");

		query.setParameter("usuario", usuario);
		ClienteEntity user = (ClienteEntity) query.getSingleResult();

		if (user == null) {
			return null;
		}
		if (user.getPassword().contentEquals(contraseña)) {
			return user;
		} else {
			return null;
		}
	}
//	
//	@Override
//	public ClienteEntity buscarPorEmail(String email) {
//		Query query = this.em.createQuery("select u FROM Profesor u where u.email= :email");
//		query.setParameter("email", email);
//		ClienteEntity profesor = (ClienteEntity) query.getSingleResult();
//
//		if (profesor != null) {
//			return profesor;
//		}
//		return null;
//	}
//
//	@Override
//	public List<ClienteEntity> buscarPorfesorPorNombreYApellidos(String nombreyapellidos) {
//
//		String nym = "%" + nombreyapellidos + "%";
//		Query query = this.em.createQuery("select u FROM Profesor u where concat (u.nombre,' 'u apellidos) like  :nym");
//		query.setParameter("nym", nym);
//		List<ClienteEntity> lProfesor = query.getResultList();
//
//		if (lProfesor != null) {
//			return lProfesor;
//		}
//		return null;
//	}
//
//	@Override
//	public List<ClienteEntity> listarPorfesores() {
//		Query query = this.em.createQuery("FROM Profesor");
//		List<ClienteEntity> lProfesor = query.getResultList();
//
//		if (lProfesor != null) {
//			return lProfesor;
//		}
//		return null;
//	}
//
//	@Override
//	public Profesor anadirEmail(long idProfesor, Email email) {
//
//		Profesor profesor = this.find(idProfesor);
//		profesor.addEmails(email);
//
//		return profesor;
//	}
//
//	@Override
//	public List<ClienteEntity> listarClientes() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public ClienteEntity findByUsername(String nombreUsuario) {
		Query query = this.em.createQuery("FROM ClienteEntity u where u.nombreUsuario = :nombreUsuario");
		query.setParameter("nombreUsuario", nombreUsuario);
		ClienteEntity user = (ClienteEntity) query.getSingleResult();

		if (user != null) {
			return user;
		}

		return null;
	}
	
	@Transactional
	public ClienteEntity create(ClienteEntity cliente) {
		Set<RolEntity> roles = new HashSet<RolEntity>();
		RolEntity rol = rolRepository.getOne(2);
		roles.add(rol);
		cliente.setRoles(roles);
		this.em.persist(cliente);
		return cliente;
	}
}
