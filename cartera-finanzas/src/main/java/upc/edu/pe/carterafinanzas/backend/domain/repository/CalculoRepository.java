package upc.edu.pe.carterafinanzas.backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Calculo;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Valor;

import java.util.List;

@Repository
public interface CalculoRepository extends JpaRepository<Calculo,Long> {

}
