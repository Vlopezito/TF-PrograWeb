package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Consultorio;

public interface IConsultorioService {
	public boolean insertar(Consultorio consultorio);
	public boolean modificar(Consultorio consultorio);
	public void eliminar(int idConsultorio);
	public Optional<Consultorio> listarId(int idConsultorio);
	List<Consultorio> listar();
	List<Consultorio> buscarNombre(String nameConsultorio);

}
