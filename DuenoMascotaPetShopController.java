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

import pe.edu.upc.spring.model.DuenoMascotaPetShop;
import pe.edu.upc.spring.model.DuenoMascota;
import pe.edu.upc.spring.model.PetShop;
import pe.edu.upc.spring.service.IDuenoMascotaPetShopService;
import pe.edu.upc.spring.service.IDuenoMascotaService;
import pe.edu.upc.spring.service.IPetShopService;



@Controller
@RequestMapping("/duenomascotapetshop")
public class DuenoMascotaPetShopController {
	
	@Autowired
	private IDuenoMascotaPetShopService pService;
	@Autowired
	private IDuenoMascotaService rService;
	@Autowired
	private IPetShopService dService;

	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}

	@RequestMapping("/")
	public String irPaginaListadoDuenoMascotaPetShop(Map<String, Object> model) {
		model.put("listaDuenoMascotasPetShops", pService.listar());
		return "listDuenoMascotaPetShop";
	}

	@RequestMapping("/irRegistrar")
	public String irRegistrar(Model model) {
		model.addAttribute("duenomascotapetshop", new DuenoMascotaPetShop());
		model.addAttribute("listaDuenoMascotas", rService.listar());
		model.addAttribute("listaPetShops", dService.listar());
		
		model.addAttribute("duenomascota", new DuenoMascota());
		model.addAttribute("petshop", new PetShop());
		model.addAttribute("duenomascotapetshop", new DuenoMascotaPetShop());
		return "duenomascotapetshop";
	}

	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute DuenoMascotaPetShop objDuenoMascotaPetShop, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors()) {
			model.addAttribute("listaDuenoMascotas", rService.listar());
			model.addAttribute("listaPetShops", dService.listar());
			return "duenomascotapetshop";
		} else {
			boolean flag = pService.insertar(objDuenoMascotaPetShop);
			if (flag) {
				return "redirect:/duenomascotapetshop/listar";
			} else {
				model.addAttribute("mensaje", "Ocurrió un error");
				return "redirect:/duenomascotapetshop/irRegistrar";
			}
		}
	}

	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<DuenoMascotaPetShop> objDuenoMascotaPetShop = pService.listarId(id);
		if (objDuenoMascotaPetShop == null) {
			objRedir.addAttribute("mensaje", "Ocurrió un error");
			return "redirect:/duenomascotapetshop/listar";
		} else {
			model.addAttribute("listaDuenoMascotas", rService.listar());
			model.addAttribute("listaPetShops", dService.listar());
			if (objDuenoMascotaPetShop.isPresent())
				objDuenoMascotaPetShop.ifPresent(o -> model.addAttribute("duenomascotapetshop", o));
			return "duenomascotapetshop";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {
				pService.eliminar(id);
				model.put("listaDuenoMascotasPetShops", pService.listar());
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrió un error");
			model.put("listaDuenoMascotasPetShops", pService.listar());
		}
		return "listDuenoMascotaPetShop";
	}

	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaDuenoMascotasPetShops", pService.listar());
		return "listDuenoMascotaPetShop";
	}

	@RequestMapping("/listarId")
	public String listar(Map<String, Object> model, @ModelAttribute DuenoMascotaPetShop duenomascotapetshop) throws ParseException {
		pService.listarId(duenomascotapetshop.getIdDuenoMascotaPetShop());
		return "listDuenoMascotaPetShop";
	}

	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute DuenoMascotaPetShop duenomascotapetshop) throws ParseException {
		List<DuenoMascotaPetShop> listaDuenoMascotasPetShops;
		duenomascotapetshop.setReferencia(duenomascotapetshop.getReferencia());
		listaDuenoMascotasPetShops = pService.buscarReferencia(duenomascotapetshop.getReferencia());

		if (listaDuenoMascotasPetShops.isEmpty()) {
			model.put("mensaje", "No se encontro");
		}
		model.put("listaDuenoMascotasPetShops", listaDuenoMascotasPetShops);
		return "buscar";
	}

	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("duenomascotapetshop", new DuenoMascotaPetShop());
		return "buscar";
	}
	
}
