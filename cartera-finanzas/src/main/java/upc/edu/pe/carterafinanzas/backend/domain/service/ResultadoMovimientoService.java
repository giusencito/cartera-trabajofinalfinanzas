package upc.edu.pe.carterafinanzas.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.ResultadoComitente;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.ResultadoMovimiento;

import java.util.List;
import java.util.Optional;

public interface ResultadoMovimientoService {






    public boolean grabar(ResultadoMovimiento resultadoMovimiento);
    public void eliminar(Long ResultadoMovimientoId);
    public Optional<ResultadoMovimiento> listarId(Long ResultadoMovimientoId);
    public List<ResultadoMovimiento> listar();








}
