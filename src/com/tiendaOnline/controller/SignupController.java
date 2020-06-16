package com.tiendaOnline.controller;

import java.sql.Date;

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
import com.tiendaOnline.service.ClienteEntityService;

@Controller
@RequestMapping(value="/signup")
public class SignupController {
		
	@Autowired
	private ClienteEntityService clienteService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String signup() {
		return "signup";
	};
	
	@Transactional
	@RequestMapping(method=RequestMethod.POST)
	public String handleSignUp(HttpServletRequest request, HttpSession session) {
		String nombre, apellidos, email, usuario, password, fechaNacimiento, direccionEnvio, banco, numeroTarjeta,
		titular, codigoSeguridad, direccionFacturacion;
		
		nombre = request.getParameter("nombre");
		apellidos = request.getParameter("apellidos");
		email = request.getParameter("email");
		usuario = request.getParameter("usuario");
		password = request.getParameter("password");
		fechaNacimiento = request.getParameter("fechaNacimiento");
		direccionEnvio = request.getParameter("direccionEnvio");
		
		banco = request.getParameter("banco");
		numeroTarjeta = request.getParameter("numeroTarjeta");
		titular = request.getParameter("titular");
		codigoSeguridad = request.getParameter("codigoSeguridad");
		direccionFacturacion = request.getParameter("direccionFacturacion");
		
		
		
		ClienteEntity cliente = new ClienteEntity(nombre, apellidos, email, usuario, password, fechaNacimiento,
				direccionEnvio, banco, numeroTarjeta, titular, codigoSeguridad, direccionFacturacion);
		
		clienteService.create(cliente);
		session.setAttribute("usuario", cliente);
		return "redirect:/login";
	}
}
