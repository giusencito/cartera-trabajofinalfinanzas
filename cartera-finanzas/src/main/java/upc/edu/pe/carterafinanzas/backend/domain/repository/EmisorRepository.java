package upc.edu.pe.carterafinanzas.backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Emisor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmisorRepository extends JpaRepository<Emisor,Long> {

    @Query("select count(a.id) from Emisor a where a.id =:id")
    public Long existeActividad(@Param("id") Long id);

    @Query("from Emisor e where e.EmisorNombre like %:nombre%")
    List<Emisor> buscarNombre(@Param("nombre") String nombre);
    
}
