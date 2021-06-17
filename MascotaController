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

import pe.edu.upc.spring.model.Mascota;
import pe.edu.upc.spring.model.DuenoMascota;

import pe.edu.upc.spring.service.IMascotaService;
import pe.edu.upc.spring.service.IDuenoMascotaService;


@Controller
@RequestMapping("/mascota")
public class MascotaController {
	
	@Autowired
	private IDuenoMascotaService dService;
	@Autowired
	private IMascotaService rService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoMascotas(Map<String, Object> model) {
		model.put("listaMascotas", rService.listar());
		
		return "listMascota";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("mascota", new Mascota());
		model.addAttribute("listaDuenoMascotas", dService.listar());
		
		model.addAttribute("duenoMascota", new DuenoMascota());
		model.addAttribute("mascota", new Mascota());
		return "mascota";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Mascota objMascota, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
			
			model.addAttribute("listaDuenoMascotas", dService.listar());
			return "mascota";}
		
		else {
			boolean flag = rService.insertar(objMascota);
			if (flag)
				return "redirect:/mascota/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/mascota/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<Mascota> objMascota = rService.listarId(id);
		if(objMascota == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/mascota/listar";
		}
		else {
			model.addAttribute("listaDuenoMascotas", dService.listar());
			model.addAttribute("mascota", objMascota);
			
			if(objMascota.isPresent())
				objMascota.ifPresent(o-> model.addAttribute("mascota",o));

			return "mascota";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				rService.eliminar(id);
				model.put("listaMascotas", rService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaMascotas", rService.listar());
		}
		return "listMascota";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaMascotas", rService.listar());
		return "listMascota";
	}
	
	
	
	
}
