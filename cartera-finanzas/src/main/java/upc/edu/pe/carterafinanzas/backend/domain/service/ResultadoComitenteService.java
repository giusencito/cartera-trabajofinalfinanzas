package upc.edu.pe.carterafinanzas.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import upc.edu.pe.carterafinanzas.backend.domain.model.entity.ResultadoComitente;

import java.util.List;
import java.util.Optional;

public interface ResultadoComitenteService {

    public boolean grabar(ResultadoComitente resultadoComitente);
    public void eliminar(Long ResultadoComitenteId);
    public Optional<ResultadoComitente> listarId(Long ResultadoComitenteId);
    public List<ResultadoComitente> listar();

}
