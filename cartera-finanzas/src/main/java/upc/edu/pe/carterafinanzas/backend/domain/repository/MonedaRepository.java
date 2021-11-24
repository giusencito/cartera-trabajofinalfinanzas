package upc.edu.pe.carterafinanzas.backend.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.*;

import java.util.List;

public interface MonedaRepository extends JpaRepository<Moneda,Long> {

    @Query("from Moneda m where m.emisor.id =:id")
    List<Moneda> findByemisorId(@Param("id") Long id);
    @Query("from Moneda m where m.valor.id =:id")
    List<Moneda> findByvalorId(@Param("id") Long id);
    @Query("from Moneda m where m.tipoMoneda.id =:id")
    List<Moneda> findBytipodemonedaId(@Param("id") Long id);
    @Query("from Moneda m where m.cartera.id =:id")
    List<Moneda>findByCarteraId(@Param("id") Long id);


}
