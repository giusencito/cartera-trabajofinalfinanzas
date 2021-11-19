package upc.edu.pe.carterafinanzas.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.ResultadoComitente;

import java.util.List;

public interface ResultadoComitenteService {

    List<ResultadoComitente> getAll();
    Page<ResultadoComitente> getAll(Pageable pageable);
    ResultadoComitente getById(Long ResultadoComitenteId);
    ResultadoComitente create(ResultadoComitente resultadoComitente);
    ResultadoComitente update(Long ResultadoComitenteId,ResultadoComitente request);
    ResponseEntity<?> delete(Long ResultadoComitenteId);
}
