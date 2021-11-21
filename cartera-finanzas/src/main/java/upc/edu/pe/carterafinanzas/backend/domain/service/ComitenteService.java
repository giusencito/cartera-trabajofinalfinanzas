package upc.edu.pe.carterafinanzas.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.*;

import java.util.List;
import java.util.Optional;

public interface ComitenteService {

    public boolean grabar(Comitente comitente);
    public void eliminar(int idComitente);
    public Optional<Comitente> listarId(int idComitente);
    public List<Comitente> listar();

}
