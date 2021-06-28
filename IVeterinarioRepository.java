package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Veterinario;

@Repository
public interface IVeterinarioRepository extends JpaRepository<Veterinario, Integer>{
	@Query("from Veterinario r where r.nameVeterinario like %:nameVeterinario%")
	List<Veterinario> buscarNombre(@Param("nameVeterinario") String nameVeterinario);

}
