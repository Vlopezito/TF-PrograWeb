package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Consultorio;

@Repository
public interface IConsultorioRepository extends JpaRepository<Consultorio, Integer>{
	@Query("from Consultorio r where r.nameConsultorio like %:nameConsultorio%")
	List<Consultorio> buscarNombre(@Param("nameConsultorio") String nameConsultorio);

}
