package upc.edu.pe.carterafinanzas.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Moneda;

import java.util.List;

public interface MonedaService {

    List<Moneda> getAll();
    Page<Moneda> getAll(Pageable pageable);
    Moneda getById(Long MonedaId);
    Moneda create(Moneda moneda);
    Moneda update(Long MonedaId,Moneda request);
    List<Moneda> findByemisorId(Long emisorId);
    List<Moneda> findByvalorId(Long valorId);
    List<Moneda> findBytipodemonedaId(Long tipodemonedaId);
    List<Moneda>findByCarteraId(Long carteraId);

}
