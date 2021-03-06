package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Mascota;
import pe.edu.upc.spring.repository.IMascotaRepository;
import pe.edu.upc.spring.service.IMascotaService;

@Service
public class MascotaServiceImpl implements IMascotaService {

	@Autowired
	private IMascotaRepository dMascota;
	
	@Override
	@Transactional
	public boolean insertar(Mascota mascota) {
		Mascota objMascota = dMascota.save(mascota);
		if(objMascota == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Mascota mascota) {
		boolean flag = false;
		try {
			dMascota.save(mascota);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio algoo MALOOOOOO...");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idMascota) {
		dMascota.deleteById(idMascota);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Mascota> listarId(int idMascota) {
		return dMascota.findById(idMascota);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Mascota> listar() {
		return dMascota.findAll();
	}

	@Override
	@Transactional
	public List<Mascota> buscarNombre(String nameMascota) {
		return dMascota.buscarNombre(nameMascota);
	}
	
	@Override
	@Transactional
	public List<Mascota> buscarPropietario(String nameDuenoMascota) {

		return dMascota.buscarPropietario(nameDuenoMascota);
	}
}
