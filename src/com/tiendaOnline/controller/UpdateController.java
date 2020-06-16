package com.tiendaOnline.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tiendaOnline.dao.ClienteDao;
import com.tiendaOnline.model.ClienteEntity;

	@Controller
	@RequestMapping(value="/updatePerfilCliente")
	public class UpdateController {
		
		@Qualifier("ClienteDaoImpl")
		@Autowired
		private ClienteDao clienteDao;
		
		@RequestMapping(method=RequestMethod.GET)
		public String updatePerfilCliente() {
			return "updatePerfilCliente";
		};
		
		@Transactional	
		@RequestMapping(method=RequestMethod.POST)
		public String handleUpdatePerfilCliente(HttpServletRequest request, HttpSession session) {
			String nombre, apellidos, email, nombreUsuario, password, fechaNacimiento, direccionEnvio, banco, numeroTarjeta,
			titular, codigoSeguridad, direccionFacturacion;
			ClienteEntity cliente = (ClienteEntity) session.getAttribute("cliente");
			
			nombre = request.getParameter("nombre");
			if(!nombre.contentEquals("")) {
				cliente.setNombre(nombre);
			}
			
			apellidos = request.getParameter("apellidos");
			if(!apellidos.contentEquals("")) {
				cliente.setApellidos(apellidos);
			}
			
			email = request.getParameter("email");
			if(!email.contentEquals("")) {
				cliente.setEmail(email);
			}
			
			nombreUsuario = request.getParameter("usuario");
			if(!nombreUsuario.contentEquals("")) {
				cliente.setNombreUsuario(nombreUsuario);
			}
			
			password = request.getParameter("password");
			if(!password.contentEquals("")) {
				cliente.setPassword(password);
			}
			
			fechaNacimiento = request.getParameter("fechaNacimiento");
			if(!fechaNacimiento.contentEquals("")) {
				cliente.setFechaNacimiento(fechaNacimiento);
			}
			
			direccionEnvio = request.getParameter("direccionEnvio");
			if(!direccionEnvio.contentEquals("")) {
				cliente.setDireccionEnvio(direccionEnvio);
			}
			
			banco = request.getParameter("banco");
			if(!banco.contentEquals("")) {
				cliente.setBanco(banco);
			}
			
			numeroTarjeta = request.getParameter("numeroTarjeta");
			if(!numeroTarjeta.contentEquals("")) {
				cliente.setNumeroTarjeta(numeroTarjeta);
			}
			
			titular = request.getParameter("titular");
			if(!titular.contentEquals("")) {
				cliente.setTitular(titular);
			}
			
			codigoSeguridad = request.getParameter("codigoSeguridad");
			if(!codigoSeguridad.contentEquals("")) {
				cliente.setCodigoSeguridad(codigoSeguridad);
			}
			
			direccionFacturacion = request.getParameter("direccionFacturacion");
			if(!direccionFacturacion.contentEquals("")) {
				cliente.setDireccionFacturacion(direccionFacturacion);
			}
			
			clienteDao.update(cliente);
			
			return "redirect:/cliente/perfilCliente";
		}
	}
	