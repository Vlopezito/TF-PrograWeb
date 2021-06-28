package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.MascotaConsultorio;


public interface IMascotaConsultorioService {
	public boolean insertar(MascotaConsultorio mascotaconsultorio);
	public boolean modificar(MascotaConsultorio mascotaconsultorio);
	public void eliminar(int idMascotaconsultorio);
	public Optional<MascotaConsultorio> listarId(int idMascotaconsultorio);
	public Optional<MascotaConsultorio> buscarId(int idMascotaconsultorio);
	List<MascotaConsultorio> listar();
	List<MascotaConsultorio> buscarMascota(String nameMascota);
	List<MascotaConsultorio> buscarConsultorio(String nameConsultorio);
	List<MascotaConsultorio> buscarEnfermedad(String enfermedad);
}
