package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.PetShop;

public interface IPetShopService {
	public boolean insertar(PetShop petshop);
	public boolean modificar(PetShop petshop);
	public void eliminar(int idPetShop);
	public Optional<PetShop> listarId(int idPetShop);
	List<PetShop> listar();
	List<PetShop> buscarNombre(String namePetShop);

}
