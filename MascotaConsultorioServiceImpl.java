package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.MascotaConsultorio;
import pe.edu.upc.spring.repository.IMascotaConsultorioRepository;
import pe.edu.upc.spring.service.IMascotaConsultorioService;

@Service
public class MascotaConsultorioServiceImpl implements IMascotaConsultorioService {

	@Autowired
	private IMascotaConsultorioRepository dMascotaConsultorio;
	
	@Override
	@Transactional
	public boolean insertar(MascotaConsultorio mascotaconsultorio) {
		MascotaConsultorio objMascotaConsultorio = dMascotaConsultorio.save(mascotaconsultorio);
		if(objMascotaConsultorio == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(MascotaConsultorio mascotaconsultorio) {
		boolean flag = false;
		try {
			dMascotaConsultorio.save(mascotaconsultorio);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio algoo MALOOOOOO...");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idMascotaConsultorio) {
		dMascotaConsultorio.deleteById(idMascotaConsultorio);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<MascotaConsultorio> listarId(int idMascotaConsultorio) {
		return dMascotaConsultorio.findById(idMascotaConsultorio);
	}

	@Override
	@Transactional(readOnly = true)
	public List<MascotaConsultorio> listar() {
		return dMascotaConsultorio.findAll();
	}

	@Override
	@Transactional
	public List<MascotaConsultorio> buscarEnfermedad(String enfermedad) {
		return dMascotaConsultorio.buscarEnfermedad(enfermedad);
	}

	@Override
	@Transactional
	public List<MascotaConsultorio> buscarMascota(String nameMascota) {
		return dMascotaConsultorio.buscarMascota(nameMascota);
	}
	
	@Override
	@Transactional
	public List<MascotaConsultorio> buscarConsultorio(String nameConsultorio) {
		return dMascotaConsultorio.buscarConsultorio(nameConsultorio);
	}

	@Override
	public Optional<MascotaConsultorio> buscarId(int idMascotaconsultorio) {
		return null;
	}
	
}
