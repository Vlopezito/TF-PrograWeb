package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Veterinario;
import pe.edu.upc.spring.repository.IVeterinarioRepository;
import pe.edu.upc.spring.service.IVeterinarioService;

@Service
public class VeterinarioServiceImpl implements IVeterinarioService {

	@Autowired
	private IVeterinarioRepository dVeterinario;
	
	@Override
	@Transactional
	public boolean insertar(Veterinario veterinario) {
		Veterinario objVeterinario  = dVeterinario .save(veterinario );
		if(objVeterinario  == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Veterinario  veterinario ) {
		boolean flag = false;
		try {
			dVeterinario.save(veterinario );
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("MUCHOSSSSS Problemitassss...");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idVeterinario) {
		dVeterinario.deleteById(idVeterinario);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Veterinario> listarId(int idVeterinario) {
		return dVeterinario.findById(idVeterinario);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Veterinario> listar() {
		return dVeterinario.findAll();
	}

	@Override
	@Transactional
	public List<Veterinario> buscarNombre(String nameVeterinario) {
		return dVeterinario.buscarNombre(nameVeterinario);
	}
	
}
