package upc.edu.pe.carterafinanzas.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Usuario;
import upc.edu.pe.carterafinanzas.backend.domain.repository.UsuarioRepository;
import upc.edu.pe.carterafinanzas.backend.domain.service.UsuarioService;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceNotFoundException;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    @Autowired
    private UsuarioRepository dUsuario;

    @Override
    @Transactional
    public boolean grabar(Usuario usuario) {
        Usuario objUsuario = dUsuario.save(usuario);
        if (objUsuario == null)
            return false;
        else
            return true;
    }


    @Override
    @Transactional
    public void eliminar(Long idUsuario) {
        dUsuario.deleteById(idUsuario);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> listarId(Long idUsuario) {
        return dUsuario.findById(idUsuario);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listar() {
        return dUsuario.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> buscarUsuario(String nombre){
        return dUsuario.buscarUsuario(nombre);

    }
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> inicioSesionUsuario(String correo, String password){
        return dUsuario.inicioSesionUsuario(correo, password);
    }

    @Override
    @Transactional
    public int existeUsuario(String correo){
        return dUsuario.UsuarioExiste(correo);
    }

    @Override
    @Transactional
    public List<Usuario> CuentaUsuario(String correo){
        return dUsuario.CuentaUsuario(correo);
    }
}
