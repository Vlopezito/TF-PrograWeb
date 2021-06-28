package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.PetShop;
import pe.edu.upc.spring.repository.IPetShopRepository;
import pe.edu.upc.spring.service.IPetShopService;

@Service
public class PetShopServiceImpl implements IPetShopService {

	@Autowired
	private IPetShopRepository dPetShop;
	
	@Override
	@Transactional
	public boolean insertar(PetShop petshop) {
		PetShop objPetShop  = dPetShop .save(petshop );
		if(objPetShop  == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(PetShop  petshop ) {
		boolean flag = false;
		try {
			dPetShop.save(petshop );
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Problemitassss...");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idPetShop) {
		dPetShop.deleteById(idPetShop);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<PetShop> listarId(int idPetShop) {
		return dPetShop.findById(idPetShop);
	}

	@Override
	@Transactional(readOnly = true)
	public List<PetShop> listar() {
		return dPetShop.findAll();
	}

	@Override
	@Transactional
	public List<PetShop> buscarNombre(String namePetShop) {
		return dPetShop.buscarNombre(namePetShop);
	}
	
}
