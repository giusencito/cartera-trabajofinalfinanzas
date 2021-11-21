package upc.edu.pe.carterafinanzas.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Moneda;

import java.util.List;
import java.util.Optional;

public interface MonedaService {

    public boolean grabar(Moneda moneda);
    public void eliminar(Long idMoneda);
    public Optional<Moneda> listarId(Long idMoneda);
    public List<Moneda> listar();
    public List<Moneda> findByemisorId(Long emisorId);
    public List<Moneda> findByvalorId(Long valorId);
    public List<Moneda> findBytipodemonedaId(Long tipodemonedaId);
    public List<Moneda>findByCarteraId(Long carteraId);

}
