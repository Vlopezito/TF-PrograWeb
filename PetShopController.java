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

import pe.edu.upc.spring.model.PetShop;
import pe.edu.upc.spring.service.IPetShopService;

@Controller
@RequestMapping("/petshop")
public class PetShopController {
	
	@Autowired
	private IPetShopService rService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoOfertas(Map<String, Object> model) {
		model.put("listaPetShops", rService.listar());
		return "listPetShop";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("petshop", new PetShop());
		return "petshop";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute PetShop objPetShop, BindingResult binRes, Model model) throws ParseException {
		if (binRes.hasErrors())
			return "petshop";
		else {
			boolean flag = rService.insertar(objPetShop);
			if (flag)
				return "redirect:/petshop/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/petshop/irRegistrar";
			}
		}
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
		Optional<PetShop> objPetShop= rService.listarId(id);
		if(objPetShop == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/petshop/listar";
		}
		else {
			model.addAttribute("petshop", objPetShop);
			return "petshop";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id>0) {
				rService.eliminar(id);
				model.put("listaPetShops", rService.listar());
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaPetShops", rService.listar());
		}
		return "listPetShop";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaPetShops", rService.listar());
		return "listPetShop";
	}
	
	
	
	
}
