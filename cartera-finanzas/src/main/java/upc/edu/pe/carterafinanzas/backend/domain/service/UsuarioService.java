package upc.edu.pe.carterafinanzas.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> getAll();
    Page<Usuario> getAll(Pageable pageable);
    Usuario getById(Long UsuarioId);
    Usuario create(Usuario usuario);
    Usuario update(Long UsuarioId,Usuario request);
    ResponseEntity<?> delete(Long UsuarioId);


}
