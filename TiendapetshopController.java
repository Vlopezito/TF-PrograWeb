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

import pe.edu.upc.spring.model.Tiendapetshop;
import pe.edu.upc.spring.service.ITiendapetshopService;

@Controller
@RequestMapping("/tiendapetshop")
public class TiendapetshopController {
	
	@Autowired
	private ITiendapetshopService rService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoTiendapetshops(Map<String, Object> model) {
		model.put("listaTiendapetshops", rService.listar());
		return "listTiendapetshop";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("tiendapetshop", new Tiendapetshop());
		return "tiendapetshop";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Tiendapetshop objTiendapetshop, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors())
			return "tiendapetshop";
		else {
			boolean flag = rService.insertar(objTiendapetshop);
			if (flag)
				return "redirect:/tiendapetshop/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/tiendapetshop/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Tiendapetshop> objTiendapetshop = rService.listarId(id);
		if(objTiendapetshop == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/tiendapetshop/listar";
		}
		else {
			model.addAttribute("tiendapetshop", objTiendapetshop);
			return "tiendapetshop";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				rService.eliminar(id);
				model.put("listaTiendapetshops", rService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaTiendapetshops", rService.listar());
		}
		return "listTiendapetshop";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaTiendapetshops", rService.listar());
		return "listTiendapetshop";
	}
	
	
	
	
}
