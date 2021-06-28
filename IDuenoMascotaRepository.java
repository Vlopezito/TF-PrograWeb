package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.DuenoMascota;

@Repository
public interface IDuenoMascotaRepository extends JpaRepository<DuenoMascota, Integer>{
	@Query("from DuenoMascota r where r.nameDuenoMascota like %:nameDuenoMascota%")
	List<DuenoMascota> buscarNombre(@Param("nameDuenoMascota") String nameDuenoMascota);

}
