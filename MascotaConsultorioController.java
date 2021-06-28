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

import pe.edu.upc.spring.model.MascotaConsultorio;
import pe.edu.upc.spring.model.Mascota;
import pe.edu.upc.spring.model.Consultorio;
import pe.edu.upc.spring.service.IMascotaConsultorioService;
import pe.edu.upc.spring.service.IMascotaService;
import pe.edu.upc.spring.service.IConsultorioService;



@Controller
@RequestMapping("/mascotaconsultorio")
public class MascotaConsultorioController {
	
	@Autowired
	private IMascotaConsultorioService pService;
	@Autowired
	private IMascotaService rService;
	@Autowired
	private IConsultorioService dService;

	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}

	@RequestMapping("/")
	public String irPaginaListadoMascotaConsultorio(Map<String, Object> model) {
		model.put("listaMascotasConsultorios", pService.listar());
		return "listMascotaConsultorio";
	}

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("mascotaconsultorio", new MascotaConsultorio());
		model.addAttribute("listaMascotas", rService.listar());
		model.addAttribute("listaConsultorios", dService.listar());
		
		model.addAttribute("mascota", new Mascota());
		model.addAttribute("consultorio", new Consultorio());
		model.addAttribute("mascotaconsultorio", new MascotaConsultorio());
		return "mascotaconsultorio";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute MascotaConsultorio objMascotaConsultorio, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
			model.addAttribute("listaMascotas", rService.listar());
			model.addAttribute("listaConsultorios", dService.listar());
			return "mascotaconsultorio";
		} else {
			boolean flag = pService.insertar(objMascotaConsultorio);
			if (flag) {
				return "redirect:/mascotaconsultorio/listar";
			} else {
				model.addAttribute("mensaje", "Ocurrió un error");
				return "redirect:/mascotaconsultorio/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<MascotaConsultorio> objMascotaConsultorio = pService.listarId(id);
		if (objMascotaConsultorio == null) {
			objRedir.addAttribute("mensaje", "Ocurrió un error");
			return "redirect:/mascotaconsultorio/listar";
		} else {
			model.addAttribute("listaMascotas", rService.listar());
			model.addAttribute("listaConsultorios", dService.listar());
			if (objMascotaConsultorio.isPresent())
				objMascotaConsultorio.ifPresent(o -> model.addAttribute("mascotaconsultorio", o));
			return "mascotaconsultorio";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				pService.eliminar(id);
				model.put("listaMascotasConsultorios", pService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrió un error");
			model.put("listaMascotasConsultorios", pService.listar());
		}
		return "listMascotaConsultorio";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaMascotasConsultorios", pService.listar());
		return "listMascotaConsultorio";
	}

	@RequestMapping("/listarId")
	public String listar(Map<String, Object> model, @ModelAttribute MascotaConsultorio mascotaconsultorio) throws ParseException {
		pService.listarId(mascotaconsultorio.getIdMascotaConsultorio());
		return "listMascotaConsultorio";
	}

	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute MascotaConsultorio mascotaconsultorio) throws ParseException {
		List<MascotaConsultorio> listaMascotasConsultorios;
		mascotaconsultorio.setEnfermedad(mascotaconsultorio.getEnfermedad());
		listaMascotasConsultorios = pService.buscarEnfermedad(mascotaconsultorio.getEnfermedad());

		if (listaMascotasConsultorios.isEmpty()) {
			model.put("mensaje", "No se encontro");
		}
		model.put("listaMascotasConsultorios", listaMascotasConsultorios);
		return "buscar";
	}

	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("mascotaconsultorio", new MascotaConsultorio());
		return "buscar";
	}
	
}
