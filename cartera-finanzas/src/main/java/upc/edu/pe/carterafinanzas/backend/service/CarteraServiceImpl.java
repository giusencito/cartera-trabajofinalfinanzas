package upc.edu.pe.carterafinanzas.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Cartera;
import upc.edu.pe.carterafinanzas.backend.domain.repository.CarteraRepository;
import upc.edu.pe.carterafinanzas.backend.domain.repository.UsuarioRepository;
import upc.edu.pe.carterafinanzas.backend.domain.service.CarteraService;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceNotFoundException;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class CarteraServiceImpl implements CarteraService {


    private static final String ENTITY = "Cartera";

    private final CarteraRepository carteraRepository;
    private final UsuarioRepository usuarioRepository;


    private final Validator validator;

    public CarteraServiceImpl(CarteraRepository carteraRepository, UsuarioRepository usuarioRepository,  Validator validator){

        this.carteraRepository=carteraRepository;
        this.usuarioRepository = usuarioRepository;

        this.validator=validator;
    }

    public List<Cartera> getAll() {
        return carteraRepository.findAll();
    }

    @Override
    public Page<Cartera> getAll(Pageable pageable) {
        return carteraRepository.findAll(pageable);
    }

    @Override
    public Cartera getById(Long CarteraId) {
        return carteraRepository.findById(CarteraId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, CarteraId));
    }

    @Override
    public Cartera create(Long userId, Cartera request) {

        return usuarioRepository.findById(userId)
                .map(publications -> {
                    request.setUsuario(publications);

                    return carteraRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Usuario", userId));
    }

    @Override
    public Cartera update(Long CarteraId, Cartera request) {
        Set<ConstraintViolation<Cartera>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return carteraRepository.findById(CarteraId).map(event ->
                carteraRepository.save(
                        event
                                .withFecha(request.getFecha())
                                .withTipodecambio(request.getTipodecambio())
                                .withValormetotal(request.getValormetotal())
                                .withValormntotal(request.getValormntotal())
                                .withValorgarantiatotal(request.getValorgarantiatotal())
                )

        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, CarteraId));
    }

    @Override
    public List<Cartera> findByUsuarioId(Long usuarioId) {
        return carteraRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public ResponseEntity<?> delete(Long usuarioId) {
        return carteraRepository.findById(usuarioId).map(post -> {
            carteraRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, usuarioId));
    }























}
