package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Oferta;

@Repository
public interface IOfertaRepository extends JpaRepository<Oferta, Integer>{
	@Query("from Oferta r where r.nameProducto like %:nameProducto%")
	List<Oferta> buscarNombre(@Param("nameProducto") String nameProducto);

}
