package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.PetShop;

@Repository
public interface IPetShopRepository extends JpaRepository<PetShop, Integer>{
	@Query("from PetShop r where r.namePetShop like %:namePetShop%")
	List<PetShop> buscarNombre(@Param("namePetShop") String namePetShop);

}
