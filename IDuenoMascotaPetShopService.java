package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.DuenoMascotaPetShop;


public interface IDuenoMascotaPetShopService {
	public boolean insertar(DuenoMascotaPetShop duenomascotapetshop);
	public boolean modificar(DuenoMascotaPetShop duenomascotapetshop);
	public void eliminar(int idDuenoMascotapetshop);
	public Optional<DuenoMascotaPetShop> listarId(int idDuenoMascotapetshop);
	public Optional<DuenoMascotaPetShop> buscarId(int idDuenoMascotapetshop);
	List<DuenoMascotaPetShop> listar();
	List<DuenoMascotaPetShop> buscarDuenoMascota(String nameDuenoMascota);
	List<DuenoMascotaPetShop> buscarPetShop(String namePetShop);
	List<DuenoMascotaPetShop> buscarReferencia(String referencia);
}
