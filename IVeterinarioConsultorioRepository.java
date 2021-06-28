package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import pe.edu.upc.spring.model.VeterinarioConsultorio;


@Repository
public interface IVeterinarioConsultorioRepository extends JpaRepository<VeterinarioConsultorio, Integer>{
	@Query("from VeterinarioConsultorio r where r.puesto like %:puesto%")
	List<VeterinarioConsultorio> buscarPuesto(@Param("puesto") String puesto);
	
	@Query("from VeterinarioConsultorio r where r.veterinario.nameVeterinario like %:nameVeterinario%")
	List<VeterinarioConsultorio> buscarVeterinario(@Param("nameVeterinario") String nameVeterinario);
	
	@Query("from VeterinarioConsultorio r where r.consultorio.nameConsultorio like %:nameConsultorio%")
	List<VeterinarioConsultorio> buscarConsultorio(@Param("nameConsultorio") String nameConsultorio);
	
}
