package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.VeterinarioConsultorio;
import pe.edu.upc.spring.repository.IVeterinarioConsultorioRepository;
import pe.edu.upc.spring.service.IVeterinarioConsultorioService;

@Service
public class VeterinarioConsultorioServiceImpl implements IVeterinarioConsultorioService {

	@Autowired
	private IVeterinarioConsultorioRepository dVeterinarioConsultorio;
	
	@Override
	@Transactional
	public boolean insertar(VeterinarioConsultorio veterinarioconsultorio) {
		VeterinarioConsultorio objVeterinarioConsultorio = dVeterinarioConsultorio.save(veterinarioconsultorio);
		if(objVeterinarioConsultorio == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(VeterinarioConsultorio veterinarioconsultorio) {
		boolean flag = false;
		try {
			dVeterinarioConsultorio.save(veterinarioconsultorio);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio algoo MALOOOOOO...");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idVeterinarioConsultorio) {
		dVeterinarioConsultorio.deleteById(idVeterinarioConsultorio);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<VeterinarioConsultorio> listarId(int idVeterinarioConsultorio) {
		return dVeterinarioConsultorio.findById(idVeterinarioConsultorio);
	}

	@Override
	@Transactional(readOnly = true)
	public List<VeterinarioConsultorio> listar() {
		return dVeterinarioConsultorio.findAll();
	}

	@Override
	@Transactional
	public List<VeterinarioConsultorio> buscarPuesto(String puesto) {
		return dVeterinarioConsultorio.buscarPuesto(puesto);
	}

	@Override
	@Transactional
	public List<VeterinarioConsultorio> buscarVeterinario(String nameVeterinario) {
		return dVeterinarioConsultorio.buscarVeterinario(nameVeterinario);
	}
	
	@Override
	@Transactional
	public List<VeterinarioConsultorio> buscarConsultorio(String nameConsultorio) {
		return dVeterinarioConsultorio.buscarConsultorio(nameConsultorio);
	}

	@Override
	public Optional<VeterinarioConsultorio> buscarId(int idVeterinarioconsultorio) {
		return null;
	}
	
}
