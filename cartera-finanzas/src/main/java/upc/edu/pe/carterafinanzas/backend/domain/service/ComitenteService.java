package upc.edu.pe.carterafinanzas.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.*;

import java.util.List;
import java.util.Optional;

public interface ComitenteService {

    public boolean grabar(Comitente comitente);
    public void eliminar(Long idComitente);
    public Optional<Comitente> listarId(Long idComitente);
    public List<Comitente> listar();
    public List<Comitente> buscarResultadoComitente(Long id);
}
