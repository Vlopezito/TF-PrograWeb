package pe.edu.upc.spring.controller;

import java.util.Map;
import java.util.Optional;

import com.sun.el.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



import pe.edu.upc.spring.model.DuenoMascota;
import pe.edu.upc.spring.service.IDuenoMascotaService;

@Controller
@RequestMapping("/duenomascota")
public class DuenoMascotaController {
	
	@Autowired
	private IDuenoMascotaService rService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoDuenoMascotas(Map<String, Object> model) {
		model.put("listaDuenoMascotas", rService.listar());
		return "listDuenoMascota";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("duenomascota", new DuenoMascota());
		return "duenomascota";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute DuenoMascota objDuenoMascota, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors())
			return "duenomascota";
		else {
			boolean flag = rService.insertar(objDuenoMascota);
			if (flag)
				return "redirect:/duenomascota/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/duenomascota/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<DuenoMascota> objDuenoMascota = rService.listarId(id);
		if(objDuenoMascota == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/duenomascota/listar";
		}
		else {
			model.addAttribute("duenomascota", objDuenoMascota);
			return "duenomascota";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				rService.eliminar(id);
				model.put("listaDuenoMascotas", rService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaDuenoMascotas", rService.listar());
		}
		return "listDuenoMascota";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaDuenoMascotas", rService.listar());
		return "listDuenoMascota";
	}
	
	
	
	
}
