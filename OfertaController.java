package pe.edu.upc.spring.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Oferta;
import pe.edu.upc.spring.service.IOfertaService;

@Controller
@RequestMapping("/oferta")
public class OfertaController {
	
	@Autowired
	private IOfertaService rService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoOfertas(Map<String, Object> model) {
		model.put("listaOfertas", rService.listar());
		return "listOferta";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("oferta", new Oferta());
		return "oferta";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Oferta objOferta, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors())
			return "oferta";
		else {
			boolean flag = rService.insertar(objOferta);
			if (flag)
				return "redirect:/oferta/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/oferta/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Oferta> objOferta = rService.listarId(id);
		if(objOferta == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/oferta/listar";
		}
		else {
			model.addAttribute("oferta", objOferta);
			return "oferta";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				rService.eliminar(id);
				model.put("listaOfertas", rService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaOfertas", rService.listar());
		}
		return "listOferta";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaOfertas", rService.listar());
		return "listOferta";
	}
	
	
	
	
}
