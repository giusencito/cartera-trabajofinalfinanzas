package upc.edu.pe.carterafinanzas.backend.domain.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Monto_Financiar;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Valor;

import java.util.List;
import java.util.Optional;

public interface Monto_FinanciarService {

    public boolean grabar(Monto_Financiar monto);
    public void eliminar(Long idMonto);
    public Optional<Monto_Financiar> listarId(Long idMonto);
    public List<Monto_Financiar> listar();
    public List<Monto_Financiar> buscarMonto(Double resultado);
}
