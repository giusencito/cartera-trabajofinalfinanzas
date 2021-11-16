package upc.edu.pe.carterafinanzas.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.ResultadoMovimiento;

import java.util.List;

public interface ResultadoMovimientoService {
    List<ResultadoMovimiento> getAll();
    Page<ResultadoMovimiento> getAll(Pageable pageable);
    ResultadoMovimiento getById(Long ResultadoMovimientoId);
    ResultadoMovimiento create(ResultadoMovimiento resultadoMovimiento);
    ResultadoMovimiento update(Long ResultadoMovimientoId,ResultadoMovimiento request);
}
