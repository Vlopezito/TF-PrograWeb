package pe.edu.upc.spring.controller;

import java.util.List;
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

import pe.edu.upc.spring.model.VeterinarioConsultorio;
import pe.edu.upc.spring.model.Veterinario;
import pe.edu.upc.spring.model.Consultorio;
import pe.edu.upc.spring.service.IVeterinarioConsultorioService;
import pe.edu.upc.spring.service.IVeterinarioService;
import pe.edu.upc.spring.service.IConsultorioService;



@Controller
@RequestMapping("/veterinarioconsultorio")
public class VeterinarioConsultorioController {
	
	@Autowired
	private IVeterinarioConsultorioService pService;
	@Autowired
	private IVeterinarioService rService;
	@Autowired
	private IConsultorioService dService;

	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}

	@RequestMapping("/")
	public String irPaginaListadoVeterinarioConsultorio(Map<String, Object> model) {
		model.put("listaVeterinariosConsultorios", pService.listar());
		return "listVeterinarioConsultorio";
	}

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("veterinarioconsultorio", new VeterinarioConsultorio());
		model.addAttribute("listaVeterinarios", rService.listar());
		model.addAttribute("listaConsultorios", dService.listar());
		
		model.addAttribute("veterinario", new Veterinario());
		model.addAttribute("consultorio", new Consultorio());
		model.addAttribute("veterinarioconsultorio", new VeterinarioConsultorio());
		return "veterinarioconsultorio";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute VeterinarioConsultorio objVeterinarioConsultorio, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
			model.addAttribute("listaVeterinarios", rService.listar());
			model.addAttribute("listaConsultorios", dService.listar());
			return "veterinarioconsultorio";
		} else {
			boolean flag = pService.insertar(objVeterinarioConsultorio);
			if (flag) {
				return "redirect:/veterinarioconsultorio/listar";
			} else {
				model.addAttribute("mensaje", "Ocurrió un error");
				return "redirect:/veterinarioconsultorio/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<VeterinarioConsultorio> objVeterinarioConsultorio = pService.listarId(id);
		if (objVeterinarioConsultorio == null) {
			objRedir.addAttribute("mensaje", "Ocurrió un error");
			return "redirect:/veterinarioconsultorio/listar";
		} else {
			model.addAttribute("listaVeterinarios", rService.listar());
			model.addAttribute("listaConsultorios", dService.listar());
			if (objVeterinarioConsultorio.isPresent())
				objVeterinarioConsultorio.ifPresent(o -> model.addAttribute("veterinarioconsultorio", o));
			return "veterinarioconsultorio";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				pService.eliminar(id);
				model.put("listaVeterinariosConsultorios", pService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrió un error");
			model.put("listaVeterinariosConsultorios", pService.listar());
		}
		return "listVeterinarioConsultorio";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaVeterinariosConsultorios", pService.listar());
		return "listVeterinarioConsultorio";
	}

	@RequestMapping("/listarId")
	public String listar(Map<String, Object> model, @ModelAttribute VeterinarioConsultorio veterinarioconsultorio) throws ParseException {
		pService.listarId(veterinarioconsultorio.getIdVeterinarioConsultorio());
		return "listVeterinarioConsultorio";
	}

	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute VeterinarioConsultorio veterinarioconsultorio) throws ParseException {
		List<VeterinarioConsultorio> listaVeterinariosConsultorios;
		veterinarioconsultorio.setPuesto(veterinarioconsultorio.getPuesto());
		listaVeterinariosConsultorios = pService.buscarPuesto(veterinarioconsultorio.getPuesto());

		if (listaVeterinariosConsultorios.isEmpty()) {
			model.put("mensaje", "No se encontro");
		}
		model.put("listaVeterinariosConsultorios", listaVeterinariosConsultorios);
		return "buscar";
	}

	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("veterinarioconsultorio", new VeterinarioConsultorio());
		return "buscar";
	}
	
}
