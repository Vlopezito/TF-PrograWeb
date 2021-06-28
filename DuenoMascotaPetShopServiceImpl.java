package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.DuenoMascotaPetShop;
import pe.edu.upc.spring.repository.IDuenoMascotaPetShopRepository;
import pe.edu.upc.spring.service.IDuenoMascotaPetShopService;

@Service
public class DuenoMascotaPetShopServiceImpl implements IDuenoMascotaPetShopService {

	@Autowired
	private IDuenoMascotaPetShopRepository dDuenoMascotaPetShop;
	
	@Override
	@Transactional
	public boolean insertar(DuenoMascotaPetShop duenomascotapetshop) {
		DuenoMascotaPetShop objDuenoMascotaPetShop = dDuenoMascotaPetShop.save(duenomascotapetshop);
		if(objDuenoMascotaPetShop == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(DuenoMascotaPetShop duenomascotapetshop) {
		boolean flag = false;
		try {
			dDuenoMascotaPetShop.save(duenomascotapetshop);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio algoo MALOOOOOO...");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idDuenoMascotaPetShop) {
		dDuenoMascotaPetShop.deleteById(idDuenoMascotaPetShop);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<DuenoMascotaPetShop> listarId(int idDuenoMascotaPetShop) {
		return dDuenoMascotaPetShop.findById(idDuenoMascotaPetShop);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DuenoMascotaPetShop> listar() {
		return dDuenoMascotaPetShop.findAll();
	}

	@Override
	@Transactional
	public List<DuenoMascotaPetShop> buscarReferencia(String referencia) {
		return dDuenoMascotaPetShop.buscarReferencia(referencia);
	}

	@Override
	@Transactional
	public List<DuenoMascotaPetShop> buscarDuenoMascota(String nameDuenoMascota) {
		return dDuenoMascotaPetShop.buscarDuenoMascota(nameDuenoMascota);
	}
	
	@Override
	@Transactional
	public List<DuenoMascotaPetShop> buscarPetShop(String namePetShop) {
		return dDuenoMascotaPetShop.buscarPetShop(namePetShop);
	}

	@Override
	public Optional<DuenoMascotaPetShop> buscarId(int idDuenoMascotapetshop) {
		return null;
	}
	
}
