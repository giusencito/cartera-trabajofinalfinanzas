package upc.edu.pe.carterafinanzas.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.TipoMoneda;
import upc.edu.pe.carterafinanzas.backend.domain.repository.TipoMonedaRepository;
import upc.edu.pe.carterafinanzas.backend.domain.service.TipoMonedaService;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceNotFoundException;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
@Service
public class TipoMonedaServiceImpl implements TipoMonedaService {



    private static final String ENTITY = "TipoMoneda";

    private final TipoMonedaRepository tipoMonedaRepository;

    private final Validator validator;

    public TipoMonedaServiceImpl(TipoMonedaRepository tipoMonedaRepository,Validator validator){

        this.tipoMonedaRepository=tipoMonedaRepository;
        this.validator=validator;


    }

    public List<TipoMoneda> getAll() {
        return tipoMonedaRepository.findAll();
    }
    @Override
    public Page<TipoMoneda> getAll(Pageable pageable) {
        return tipoMonedaRepository.findAll(pageable);
    }
    @Override
    public TipoMoneda getById(Long userid) {
        return tipoMonedaRepository.findById(userid)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, userid));
    }

    @Override
    public TipoMoneda create(TipoMoneda request) {
        Set<ConstraintViolation<TipoMoneda>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return tipoMonedaRepository.save(request);
    }

    @Override
    public TipoMoneda update(Long userId, TipoMoneda request) {

        Set<ConstraintViolation<TipoMoneda>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return tipoMonedaRepository.findById(userId).map(user ->
                tipoMonedaRepository.save(
                        user.withNombreMoneda(request.getNombreMoneda())

                )


        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, userId));





    }

    @Override
    public ResponseEntity<?> delete(Long userid) {
        return tipoMonedaRepository.findById(userid).map(post -> {
            tipoMonedaRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, userid));
    }








































}
