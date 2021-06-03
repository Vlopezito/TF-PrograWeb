package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Tiendapetshop;

public interface ITiendapetshopService {
	public boolean insertar(Tiendapetshop tiendapetshop);
	public boolean modificar(Tiendapetshop tiendapetshop);
	public void eliminar(int idTiendapetshop);
	public Optional<Tiendapetshop> listarId(int idTiendapetshop);
	List<Tiendapetshop> listar();
	List<Tiendapetshop> buscarNombre(String nameTiendapetshop);

}
