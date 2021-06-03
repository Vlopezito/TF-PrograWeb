package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Tiendapetshop;

@Repository
public interface ITiendapetshopRepository extends JpaRepository<Tiendapetshop, Integer>{
	@Query("from Tiendapetshop r where r.nameTiendapetshop like %:nameTiendapetshop%")
	List<Tiendapetshop> buscarNombre(@Param("nameTiendapetshop") String nameTiendapetshop);

}
