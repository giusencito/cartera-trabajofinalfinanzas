package upc.edu.pe.carterafinanzas.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Descuento;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Monto_Financiar;

import java.util.List;
import java.util.Optional;

public interface DescuentoService {

    public boolean grabar(Descuento descuento);
    public void eliminar(Long idDescuento);
    public Optional<Descuento> listarId(Long idDescuento);
    public List<Descuento> listar();
    public List<Descuento> buscarDescuentoMN(Double valorMN);
    public List<Descuento> buscarDescuentoME(Double valorME);
}
