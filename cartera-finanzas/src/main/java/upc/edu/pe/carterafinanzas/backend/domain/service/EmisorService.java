package upc.edu.pe.carterafinanzas.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Emisor;

import java.util.List;

public interface EmisorService {

    List<Emisor> getAll();
    Page<Emisor> getAll(Pageable pageable);
    Emisor getById(Long EmisorId);
    Emisor create(Emisor emisor);
    Emisor update(Long EmisorId,Emisor request);
    ResponseEntity<?> delete(Long EmisorId);



}
