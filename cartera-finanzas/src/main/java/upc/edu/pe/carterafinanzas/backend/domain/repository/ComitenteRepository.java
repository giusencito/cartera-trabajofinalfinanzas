package upc.edu.pe.carterafinanzas.backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.*;

import java.util.List;

public interface ComitenteRepository extends JpaRepository<Comitente,Integer> {

}
