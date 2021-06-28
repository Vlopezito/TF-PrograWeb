package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Consultorio;
import pe.edu.upc.spring.repository.IConsultorioRepository;
import pe.edu.upc.spring.service.IConsultorioService;

@Service
public class ConsultorioServiceImpl implements IConsultorioService {

	@Autowired
	private IConsultorioRepository dConsultorio;
	
	@Override
	@Transactional
	public boolean insertar(Consultorio consultorio) {
		Consultorio objConsultorio  = dConsultorio .save(consultorio );
		if(objConsultorio  == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Consultorio  consultorio ) {
		boolean flag = false;
		try {
			dConsultorio.save(consultorio );
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Problemitassss...");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idConsultorio) {
		dConsultorio.deleteById(idConsultorio);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Consultorio> listarId(int idConsultorio) {
		return dConsultorio.findById(idConsultorio);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Consultorio> listar() {
		return dConsultorio.findAll();
	}

	@Override
	@Transactional
	public List<Consultorio> buscarNombre(String nameConsultorio) {
		return dConsultorio.buscarNombre(nameConsultorio);
	}
	
}
