package upc.edu.pe.carterafinanzas.backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.*;

import java.util.List;

public interface ComitenteRepository extends JpaRepository<Comitente,Long> {

    List<Comitente> findByemisorId(Long emisorId);
    List<Comitente> findByvalorId(Long valorId);
    List<Comitente> findByresultadocomitenteId(Long resultadocomitenteId);


}
