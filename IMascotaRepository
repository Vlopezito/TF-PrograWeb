package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Mascota;


@Repository
public interface IMascotaRepository extends JpaRepository<Mascota, Integer>{
	@Query("from Mascota r where r.nameMascota like %:nameMascota%")
	List<Mascota> buscarNombre(@Param("nameMascota") String nameMascota);
	@Query("from Mascota r where r.duenoMascota.nameDuenoMascota like %:nameDuenoMascota%")
	List<Mascota> buscarPropietario(@Param("nameDuenoMascota") String  nameDuenoMascota);
}
