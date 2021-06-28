package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import pe.edu.upc.spring.model.DuenoMascotaPetShop;


@Repository
public interface IDuenoMascotaPetShopRepository extends JpaRepository<DuenoMascotaPetShop, Integer>{
	@Query("from DuenoMascotaPetShop r where r.referencia like %:referencia%")
	List<DuenoMascotaPetShop> buscarReferencia(@Param("referencia") String referencia);
	
	@Query("from DuenoMascotaPetShop r where r.veterinario.nameDuenoMascota like %:nameDuenoMascota%")
	List<DuenoMascotaPetShop> buscarDuenoMascota(@Param("nameDuenoMascota") String nameDuenoMascota);
	
	@Query("from DuenoMascotaPetShop r where r.petshop.namePetShop like %:namePetShop%")
	List<DuenoMascotaPetShop> buscarPetShop(@Param("namePetShop") String namePetShop);
	
}
