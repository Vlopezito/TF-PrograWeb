package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.DuenoMascota;
import pe.edu.upc.spring.repository.IDuenoMascotaRepository;
import pe.edu.upc.spring.service.IDuenoMascotaService;

@Service
public class DuenoMascotaServiceImpl implements IDuenoMascotaService {

	@Autowired
	private IDuenoMascotaRepository dDuenoMascota;
	
	@Override
	@Transactional
	public boolean insertar(DuenoMascota duenomascota) {
		DuenoMascota objDuenoMascota = dDuenoMascota.save(duenomascota);
		if(objDuenoMascota == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(DuenoMascota duenomascota) {
		boolean flag = false;
		try {
			dDuenoMascota.save(duenomascota);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un roche...");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idDuenoMascota) {
		dDuenoMascota.deleteById(idDuenoMascota);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<DuenoMascota> listarId(int idDuenoMascota) {
		return dDuenoMascota.findById(idDuenoMascota);
	}

	@Override
	@Transactional(readOnly = true)
	public List<DuenoMascota> listar() {
		return dDuenoMascota.findAll();
	}

	@Override
	@Transactional
	public List<DuenoMascota> buscarNombre(String nameDuenoMascota) {
		return dDuenoMascota.buscarNombre(nameDuenoMascota);
	}
	
}
