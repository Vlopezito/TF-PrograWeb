package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.VeterinarioConsultorio;


public interface IVeterinarioConsultorioService {
	public boolean insertar(VeterinarioConsultorio veterinarioconsultorio);
	public boolean modificar(VeterinarioConsultorio veterinarioconsultorio);
	public void eliminar(int idVeterinarioconsultorio);
	public Optional<VeterinarioConsultorio> listarId(int idVeterinarioconsultorio);
	public Optional<VeterinarioConsultorio> buscarId(int idVeterinarioconsultorio);
	List<VeterinarioConsultorio> listar();
	List<VeterinarioConsultorio> buscarVeterinario(String nameVeterinario);
	List<VeterinarioConsultorio> buscarConsultorio(String nameConsultorio);
	List<VeterinarioConsultorio> buscarPuesto(String puesto);
}
