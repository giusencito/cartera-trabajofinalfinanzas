package upc.edu.pe.carterafinanzas.backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.*;

import java.util.List;

public interface ComitenteRepository extends JpaRepository<Comitente,Long> {
    @Query("from Comitente c where c.resultadoComitente.id  =:id")
    List<Comitente> buscarResultadoComitente(@Param("id") Long id);
}
