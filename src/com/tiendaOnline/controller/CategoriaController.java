package com.tiendaOnline.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tiendaOnline.model.ClienteEntity;
import com.tiendaOnline.model.ProductoEntity;
import com.tiendaOnline.service.CategoriaEntityService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaEntityService categoriaEntityService;
	
	private ClienteEntity cliente;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/listaCategoria")
	public ModelAndView listaCategoria(HttpServletRequest http) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("listaCategorias", categoriaEntityService.findAll());
		HttpSession session = http.getSession(true);
		cliente = (ClienteEntity) session.getAttribute("cliente");
		mav.setViewName("categoria");
		
		return mav;
	}
}
