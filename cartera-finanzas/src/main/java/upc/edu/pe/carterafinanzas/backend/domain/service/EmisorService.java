package upc.edu.pe.carterafinanzas.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Emisor;

import java.util.List;
import java.util.Optional;

public interface EmisorService {



    public boolean grabar(Emisor emisor);
    public void eliminar(Long EmisorId);
    public Optional<Emisor> listarId(Long EmisorId);
    public List<Emisor> listar();
    public List<Emisor> buscarNombre(String nombre);
}
