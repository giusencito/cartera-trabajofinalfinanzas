package upc.edu.pe.carterafinanzas.backend.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import upc.edu.pe.carterafinanzas.backend.domain.model.entity.*;

import java.util.List;

public interface MonedaRepository extends JpaRepository<Moneda,Long> {


    List<Moneda> findByemisorId(Long emisorId);
    List<Moneda> findByvalorId(Long valorId);
    List<Moneda> findBytipodemonedaId(Long tipodemonedaId);
    List<Moneda>findByCarteraId(Long carteraId);


}
