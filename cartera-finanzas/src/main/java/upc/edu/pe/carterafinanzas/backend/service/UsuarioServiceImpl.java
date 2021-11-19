package upc.edu.pe.carterafinanzas.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Usuario;
import upc.edu.pe.carterafinanzas.backend.domain.repository.UsuarioRepository;
import upc.edu.pe.carterafinanzas.backend.domain.service.UsuarioService;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceNotFoundException;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class UsuarioServiceImpl implements UsuarioService {




    private static final String ENTITY = "Usuario";

    private final UsuarioRepository usuarioRepository;

    private final Validator validator;

    public UsuarioServiceImpl( UsuarioRepository usuarioRepository,Validator validator){

        this.usuarioRepository=usuarioRepository;
        this.validator=validator;


    }

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }
    @Override
    public Page<Usuario> getAll(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }
    @Override
    public Usuario getById(Long userid) {
        return usuarioRepository.findById(userid)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, userid));
    }

    @Override
    public Usuario create(Usuario request) {
        Set<ConstraintViolation<Usuario>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return usuarioRepository.save(request);
    }

    @Override
    public Usuario update(Long userId, Usuario request) {

        Set<ConstraintViolation<Usuario>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return usuarioRepository.findById(userId).map(user ->
                usuarioRepository.save(
                        user.withNombre(request.getNombre())
                                .withDirreccion(request.getDirreccion())
                                .withCiudad(request.getCiudad())
                                .withEmail(request.getEmail())
                                .withPassword(request.getPassword())

                )


        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, userId));





    }

    @Override
    public ResponseEntity<?> delete(Long userid) {
        return usuarioRepository.findById(userid).map(post -> {
            usuarioRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, userid));
    }





























































}
