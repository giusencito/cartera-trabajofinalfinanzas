package upc.edu.pe.carterafinanzas.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Valor;

import java.util.List;

public interface ValorService {

    List<Valor> getAll();
    Page<Valor> getAll(Pageable pageable);
    Valor getById(Long valorId);
    Valor create(Valor valor);
    Valor update(Long valorId,Valor request);
    ResponseEntity<?> delete(Long valorId);


}
