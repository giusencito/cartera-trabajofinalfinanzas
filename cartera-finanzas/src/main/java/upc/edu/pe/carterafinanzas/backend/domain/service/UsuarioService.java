package upc.edu.pe.carterafinanzas.backend.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    public boolean grabar(Usuario usuario);
    public void eliminar(Long idUsuario);
    public Optional<Usuario> listarId(Long idUsuario);
    public List<Usuario> listar();
    public List<Usuario> buscarUsuario(String nombre);
    public List<Usuario> inicioSesionUsuario(String correo, String password);
    public int existeUsuario(String correo);
    public List<Usuario> CuentaUsuario(String correo);


}
