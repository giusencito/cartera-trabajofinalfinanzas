package upc.edu.pe.carterafinanzas.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Descuento;

import java.util.List;

public interface DescuentoService {

    List<Descuento> getAll();
    Page<Descuento> getAll(Pageable pageable);
    Descuento getById(Long DescuentoId);
    Descuento create(Descuento descuento);
    Descuento update(Long DescuentoId,Descuento request);
    List<Descuento> findByemisorId(Long emisorId);
    List<Descuento> findByValorId(Long valorId);
    List<Descuento> findBytipodemonedaId(Long tipodemonedaId);


}
