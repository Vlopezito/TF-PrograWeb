package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import pe.edu.upc.spring.model.MascotaConsultorio;


@Repository
public interface IMascotaConsultorioRepository extends JpaRepository<MascotaConsultorio, Integer>{
	@Query("from MascotaConsultorio r where r.enfermedad like %:enfermedad%")
	List<MascotaConsultorio> buscarEnfermedad(@Param("enfermedad") String enfermedad);
	
	@Query("from MascotaConsultorio r where r.mascota.nameMascota like %:nameMascota%")
	List<MascotaConsultorio> buscarMascota(@Param("nameMascota") String nameMascota);
	
	@Query("from MascotaConsultorio r where r.consultorio.nameConsultorio like %:nameConsultorio%")
	List<MascotaConsultorio> buscarConsultorio(@Param("nameConsultorio") String nameConsultorio);
	
}
