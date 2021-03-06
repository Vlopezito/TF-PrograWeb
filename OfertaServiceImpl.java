package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Oferta;
import pe.edu.upc.spring.repository.IOfertaRepository;
import pe.edu.upc.spring.service.IOfertaService;

@Service
public class OfertaServiceImpl implements IOfertaService {

	@Autowired
	private IOfertaRepository dOferta;
	
	@Override
	@Transactional
	public boolean insertar(Oferta oferta) {
		Oferta objOferta  = dOferta .save(oferta );
		if(objOferta  == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Oferta  oferta ) {
		boolean flag = false;
		try {
			dOferta .save(oferta );
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Problemitassss...");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idOferta) {
		dOferta.deleteById(idOferta);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Oferta> listarId(int idOferta) {
		return dOferta.findById(idOferta);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Oferta> listar() {
		return dOferta.findAll();
	}

	@Override
	@Transactional
	public List<Oferta> buscarNombre(String nameProducto) {
		return dOferta.buscarNombre(nameProducto);
	}
	
}
