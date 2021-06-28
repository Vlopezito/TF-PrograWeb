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

import pe.edu.upc.spring.model.Veterinario;
import pe.edu.upc.spring.service.IVeterinarioService;

@Controller
@RequestMapping("/veterinario")
public class VeterinarioController {
	
	@Autowired
	private IVeterinarioService rService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoVeterinarios(Map<String, Object> model) {
		model.put("listaVeterinarios", rService.listar());
		return "listVeterinario";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("veterinario", new Veterinario());
		return "veterinario";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Veterinario objVeterinario, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors())
			return "veterinario";
		else {
			boolean flag = rService.insertar(objVeterinario);
			if (flag)
				return "redirect:/veterinario/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/veterinario/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Veterinario> objVeterinario= rService.listarId(id);
		if(objVeterinario == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/veterinario/listar";
		}
		else {
			model.addAttribute("veterinario", objVeterinario);
			return "veterinario";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				rService.eliminar(id);
				model.put("listaVeterinarios", rService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaVeterinarios", rService.listar());
		}
		return "listVeterinario";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaVeterinarios", rService.listar());
		return "listVeterinario";
	}
	
	
	
	
}
