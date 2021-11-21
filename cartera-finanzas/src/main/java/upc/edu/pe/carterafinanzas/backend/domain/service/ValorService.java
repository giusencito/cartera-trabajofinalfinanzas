package upc.edu.pe.carterafinanzas.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Valor;

import java.util.List;
import java.util.Optional;

public interface ValorService {

    public boolean grabar(Valor valor);
    public void eliminar(int idValor);
    public Optional<Valor> listarId(int idValor);
    public List<Valor> listar();
    public List<Valor> buscarValor(String valor);

}
