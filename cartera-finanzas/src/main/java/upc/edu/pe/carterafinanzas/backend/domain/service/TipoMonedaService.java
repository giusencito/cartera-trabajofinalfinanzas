package upc.edu.pe.carterafinanzas.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.TipoMoneda;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface TipoMonedaService {


    public boolean grabar(TipoMoneda tipomoneda);
    public void eliminar(Long idTipoMoneda);
    public Optional<TipoMoneda> listarId(Long idTipoMoneda);
    public List<TipoMoneda> listar();
    public List<TipoMoneda> buscarTipoMoneda(String nombre);


}
