package com.tiendaOnline.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tiendaOnline.dto.ProductoDto;
import com.tiendaOnline.model.ClienteEntity;
import com.tiendaOnline.model.ProductoEntity;
import com.tiendaOnline.service.ProductoEntityService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	ProductoEntityService productoEntityService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/inicio")
	public ModelAndView inicio(HttpServletRequest http) {
		
		ModelAndView mav = new ModelAndView();
		List<ProductoEntity> productos;
		productos = productoEntityService.obtenerProductos();
		for(int i = 0; i < productos.size() ; i ++) {
			System.out.println("Esta es la lista de productos" + productos.get(i));
		}
		mav.addObject("productos", productos);
		HttpSession session = http.getSession(true);
		mav.setViewName("inicio");
		
		return mav;
	}
	
	//Crear producto
	
	@RequestMapping(method = RequestMethod.GET, value = "/crearProducto")
	public ModelAndView crearProducto(HttpServletRequest http) {
		
		ModelAndView mav = new ModelAndView();
		HttpSession session = http.getSession(true);
		mav.setViewName("crearProducto");
		
		return mav;
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/crearProducto")
	public ModelAndView crearProducto(HttpServletRequest request, HttpSession session, @RequestParam("nombreProducto") String nombreProducto, @RequestParam("Precio") String precio, @RequestParam("Stock") String stock/*, @RequestParam("nombreCategoria") String nombreCategoria*/) {
		
		ModelAndView mav = new ModelAndView();
		session.getAttribute("cuenta");
		ProductoEntity producto = new ProductoEntity();
		producto.setNombreProducto(nombreProducto);
		producto.setPrecio(Double.parseDouble(precio));
		producto.setStock(Integer.parseInt(stock));
		System.out.println("Este es el producto " +producto.toString());
		productoEntityService.create(producto);
		//productoEntityService.crearProducto(producto, nombreCategoria);		
		mav.setViewName("crearProducto");
		return mav;
	}
	
    //Editar Producto
	@GetMapping({ "/editarProducto/{idProducto}" })
	public ModelAndView edicionProducto(HttpServletRequest request, HttpSession session,
			@PathVariable("idProducto") long idProducto) {
		ModelAndView mav = new ModelAndView();
		session.getAttribute("cuenta");
		ProductoEntity producto = productoEntityService.obtenerProductoPorId(idProducto);
		mav.addObject("producto", producto);
		mav.setViewName("editarProducto");
		return mav;
	}

	@RequestMapping(method = { RequestMethod.POST }, value = { "/editarProducto/{idProducto}" })
	public ModelAndView editarProducto(HttpServletRequest request, HttpSession session,
			@PathVariable("idProducto") long idProducto, @RequestParam("nombreProducto") @Valid String nombreProducto,
			@RequestParam("precio") @Valid String precio, @RequestParam("stock") @Valid String stock/*,
			@RequestParam("categoria") @Valid String categoria*/) {

		ModelAndView mav = new ModelAndView();
		ProductoEntity producto = productoEntityService.obtenerProductoPorId(idProducto);
		session.getAttribute("cuenta");

		//producto = productoEntityService.comprobarEdicionProducto(producto, nombreProducto, precio, stock, categoria);

		this.productoEntityService.update(producto);
		mav.addObject("producto", producto);
		mav.setViewName("redirect:/producto/inicio");
		return mav;
	}
	
	
	//Borrar producto
	
	@GetMapping({"/borrarProducto/{idProducto}"})
	public String eliminarProducto(@PathVariable("idProducto") long idProducto) {
		this.productoEntityService.borrarProducto(idProducto);
		return "redirect:/producto/inicio";
	}
	

	
    @GetMapping("/perfilProducto/{idProducto}")
    public ModelAndView perfilProducto(HttpServletRequest request, HttpSession session, @PathVariable("idProducto") long idProducto) {
		HttpSession httpSesion = request.getSession();
		ModelAndView mav = new ModelAndView();
	//	if (httpSesion.getAttribute("idSession") != null) {
	//		long id = (long) httpSesion.getAttribute("idSession");
	//		ClienteEntity cliente = clienteEntityService.obtenerCliente(id);
	//	}
		
		ProductoEntity producto = productoEntityService.obtenerProductoPorId(idProducto);
	//	Categoria categoria = categoriaService.listarCategoriaPorProducto(producto);
		
	//	if (httpSesion.getAttribute("idSession") != null) {
	//		long id = (long) httpSesion.getAttribute("idSession");
	//		Cliente cliente = clienteService.obtenerCliente(id);
	//		List<PreguntaEntity> listaPregunta = preguntaService.listarPreguntas(producto, cliente);
	//		List<ArrayList> listaRespuestas = new ArrayList<ArrayList>();
	//		for (Pregunta pregunta : listaPregunta) {
	//			ArrayList<RespuestaEntity> listar = new ArrayList<RespuestaEntity>();
	//			listar = (ArrayList<RespuestaEntity>) respuestaService.listarRespuestas(pregunta, cliente);
	//			listaRespuestas.add(listar);
	//		}
	//		if (listaPregunta != null) {
	//			modelView.addObject("preguntas", listaPregunta);
	//		}
	//		if (listaRespuestas != null) {
	//			modelView.addObject("respuestas", listaRespuestas);
	//		}
	//	}

		httpSesion.setAttribute("ProductoSession", producto);
		mav.addObject("producto", producto);
	//	modelView.addObject("categoria", categoria);
		mav.setViewName("perfilProducto");
		return mav;
    }
    
    @RequestMapping (method = RequestMethod.GET, value ="/search/{nombreProducto}")     
    public @ResponseBody List<ProductoDto> buscarProductoPorNombre (@PathVariable("nombreProducto") String nombreProducto){         
    	List<ProductoDto> LProductos = productoEntityService.findByName(nombreProducto);          
    	return LProductos;     
    	}           
    @RequestMapping(method = RequestMethod.POST, value = "/perfilAjax/{idProducto}")     
    public String perfilAjax(@PathVariable("idProducto") long idProducto,  HttpServletRequest request) {          
    	return "redirect:/perfilProducto/" + idProducto;     
    	}
    
}
