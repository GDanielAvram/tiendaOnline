package com.tiendaOnline.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tiendaOnline.model.ClienteEntity;
import com.tiendaOnline.service.ClienteEntityService;

@Controller
@RequestMapping(value="/login")
public class LoginController {
	
	@Autowired
	private ClienteEntityService clienteDao;
	
	@RequestMapping(method=RequestMethod.GET)
	public String login() {
		return "login";
	};
	
	@Transactional	
	@RequestMapping(method=RequestMethod.POST)
	public String handleLogin(HttpServletRequest request, HttpSession session) {
		String usuario, password;
		usuario = request.getParameter("usuario");
		password = request.getParameter("password");
		
		ClienteEntity cliente = clienteDao.autenticarUsuario(usuario, password);
		session.setAttribute("cliente", cliente);
		
		if(cliente == null) {
			return "redirect:/";
		}else {
			session.setAttribute("cliente", cliente);
			return "redirect:/inicio";
		}	
	}
	
	@GetMapping("/logOut")
	public ModelAndView handleLogOut(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		HttpSession sessionLogOut = request.getSession(true);
		
		sessionLogOut.invalidate();
		mav.setViewName("index");
		
		return mav;
	}
	
}
