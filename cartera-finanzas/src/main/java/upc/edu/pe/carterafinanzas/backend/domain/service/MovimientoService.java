package upc.edu.pe.carterafinanzas.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Movimiento;

import java.util.List;

public interface MovimientoService {


    List<Movimiento> getAll();
    Page<Movimiento> getAll(Pageable pageable);
    Movimiento getById(Long MovimientoId);
    Movimiento create(Long tipodemonedaId,Long ResultadoMovimientoId,Movimiento movimiento);
    Movimiento update(Long MovimientoId,Movimiento request);
    ResponseEntity<?> delete(Long MovimientoId);
    List<Movimiento> findBytipodemonedaId(Long tipodemonedaId);
    List<Movimiento> findByResultadoMovimientoId(Long ResultadoMovimientoId);
}
