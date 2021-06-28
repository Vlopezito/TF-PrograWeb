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

import pe.edu.upc.spring.model.Consultorio;
import pe.edu.upc.spring.service.IConsultorioService;

@Controller
@RequestMapping("/consultorio")
public class ConsultorioController {
	
	@Autowired
	private IConsultorioService rService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoOfertas(Map<String, Object> model) {
		model.put("listaConsultorios", rService.listar());
		return "listConsultorio";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("consultorio", new Consultorio());
		return "consultorio";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Consultorio objConsultorio, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors())
			return "consultorio";
		else {
			boolean flag = rService.insertar(objConsultorio);
			if (flag)
				return "redirect:/consultorio/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/consultorio/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Consultorio> objConsultorio= rService.listarId(id);
		if(objConsultorio == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/consultorio/listar";
		}
		else {
			model.addAttribute("consultorio", objConsultorio);
			return "consultorio";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				rService.eliminar(id);
				model.put("listaConsultorios", rService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaConsultorios", rService.listar());
		}
		return "listConsultorio";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaConsultorios", rService.listar());
		return "listConsultorio";
	}
	
	
	
	
}
