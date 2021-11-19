package upc.edu.pe.carterafinanzas.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Valor;
import upc.edu.pe.carterafinanzas.backend.domain.repository.ValorRepository;
import upc.edu.pe.carterafinanzas.backend.domain.service.ValorService;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceNotFoundException;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;


@Service
public class ValorServiceImpl implements ValorService {



    private static final String ENTITY = "Valor";

    private final ValorRepository valorRepository;

    private final Validator validator;

    public ValorServiceImpl(ValorRepository valorRepository,Validator validator){

        this.valorRepository=valorRepository;
        this.validator=validator;


    }

    public List<Valor> getAll() {
        return valorRepository.findAll();
    }
    @Override
    public Page<Valor> getAll(Pageable pageable) {
        return valorRepository.findAll(pageable);
    }
    @Override
    public Valor getById(Long userid) {
        return valorRepository.findById(userid)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, userid));
    }

    @Override
    public Valor create(Valor request) {
        Set<ConstraintViolation<Valor>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return valorRepository.save(request);
    }

    @Override
    public Valor update(Long userId, Valor request) {

        Set<ConstraintViolation<Valor>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return valorRepository.findById(userId).map(user ->
                valorRepository.save(
                        user.withValorNombre(request.getValorNombre())

                )


        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, userId));





    }

    @Override
    public ResponseEntity<?> delete(Long userid) {
        return valorRepository.findById(userid).map(post -> {
            valorRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, userid));
    }











































}
