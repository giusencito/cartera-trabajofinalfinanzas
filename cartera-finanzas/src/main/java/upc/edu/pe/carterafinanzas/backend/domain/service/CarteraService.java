package upc.edu.pe.carterafinanzas.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Cartera;

import java.util.List;

public interface CarteraService {

    List<Cartera> getAll();
    Page<Cartera> getAll(Pageable pageable);
    Cartera getById(Long CarteraId);
    Cartera create(Long usuarioId,Cartera cartera);
    Cartera update(Long CarteraId,Cartera request);
    ResponseEntity<?> delete(Long CarteraId);
    List<Cartera> findByUsuarioId(Long usuarioId);



}
