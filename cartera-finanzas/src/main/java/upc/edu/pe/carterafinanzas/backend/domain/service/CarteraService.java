package upc.edu.pe.carterafinanzas.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Cartera;

import java.util.List;
import java.util.Optional;

public interface CarteraService {

    public boolean grabar(Cartera cartera);
    public void eliminar(Long idCartera);
    public Optional<Cartera> listarId(Long idCartera);
    public List<Cartera> listar();
    public List<Cartera> findByUsuarioId(Long usuarioId);



}
