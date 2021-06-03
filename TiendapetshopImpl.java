package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Tiendapetshop;
import pe.edu.upc.spring.repository.ITiendapetshopRepository;
import pe.edu.upc.spring.service.ITiendapetshopService;

@Service
public class TiendapetshopImpl implements ITiendapetshopService {

	@Autowired
	private ITiendapetshopRepository dTiendapetshop;
	
	@Override
	@Transactional
	public boolean insertar(Tiendapetshop tiendapetshop) {
		Tiendapetshop objTiendapetshop = dTiendapetshop.save(tiendapetshop);
		if(objTiendapetshop == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Tiendapetshop tiendapetshop) {
		boolean flag = false;
		try {
			dTiendapetshop.save(tiendapetshop);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un roche...");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idTiendapetshop) {
		dTiendapetshop.deleteById(idTiendapetshop);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Tiendapetshop> listarId(int idTiendapetshop) {
		return dTiendapetshop.findById(idTiendapetshop);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tiendapetshop> listar() {
		return dTiendapetshop.findAll();
	}

	@Override
	@Transactional
	public List<Tiendapetshop> buscarNombre(String nameTiendapetshop) {
		return dTiendapetshop.buscarNombre(nameTiendapetshop);
	}
	
}
