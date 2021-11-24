package upc.edu.pe.carterafinanzas.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Movimiento;

import java.util.List;
import java.util.Optional;

public interface MovimientoService {






    public boolean grabar(Movimiento kp);
    public void eliminar(Long idKPI);
    public Optional<Movimiento> listarId(Long idPI);
    public List<Movimiento> listar();
    public List<Movimiento> buscarnoneda(String nombre);
    public List<Movimiento> buscarresultadomovimiento(Long id);




}
