package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Mascota;


public interface IMascotaService {
	public boolean insertar(Mascota mascota);
	public boolean modificar(Mascota mascota);
	public void eliminar(int idMascota);
	public Optional<Mascota> listarId(int idMascota);
	List<Mascota> listar();
	List<Mascota> buscarNombre(String nameMascota);
	public List<Mascota> buscarPropietario(String  nameDuenoMascota);
}
