package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Veterinario;

public interface IVeterinarioService {
	public boolean insertar(Veterinario veterinario);
	public boolean modificar(Veterinario veterinario);
	public void eliminar(int idVeterinario);
	public Optional<Veterinario> listarId(int idVeterinario);
	List<Veterinario> listar();
	List<Veterinario> buscarNombre(String nameVeterinario);

}
