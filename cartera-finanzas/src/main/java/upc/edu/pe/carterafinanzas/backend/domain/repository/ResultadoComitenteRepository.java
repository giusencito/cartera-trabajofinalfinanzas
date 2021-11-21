package upc.edu.pe.carterafinanzas.backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Movimiento;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.ResultadoComitente;

public interface ResultadoComitenteRepository extends JpaRepository<ResultadoComitente,Long> {


    @Query("select count(a.id) from ResultadoComitente a where a.id =:id")
    public Long existeActividad(@Param("id") Long id);



}
