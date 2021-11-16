package upc.edu.pe.carterafinanzas.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.TipoMoneda;

import java.util.List;

public interface TipoMonedaService {


    List<TipoMoneda> getAll();
    Page<TipoMoneda> getAll(Pageable pageable);
    TipoMoneda getById(Long TipoMonedaId);
    TipoMoneda create(TipoMoneda tipoMoneda);
    TipoMoneda update(Long TipoMonedaId,TipoMoneda request);
    ResponseEntity<?> delete(Long TipoMonedaId);




}
