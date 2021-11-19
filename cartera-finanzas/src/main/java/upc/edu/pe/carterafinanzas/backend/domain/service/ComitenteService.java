package upc.edu.pe.carterafinanzas.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Comitente;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Emisor;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.ResultadoComitente;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Valor;

import java.util.List;

public interface ComitenteService {

    List<Comitente> getAll();
    Page<Comitente> getAll(Pageable pageable);
    Comitente getById(Long ComitenteId);
    Comitente create(Long emisorId, Long valorId,Long resultadocomitenteId,Comitente comitente);
    Comitente update(Long ComitenteId,Comitente request);
    ResponseEntity<?> delete(Long ComitenteId);
    List<Comitente> findByemisorId(Long emisorId);
    List<Comitente> findByvalorId(Long valorId);
    List<Comitente> findByresultadocomitenteId(Long resultadocomitenteId);

}
