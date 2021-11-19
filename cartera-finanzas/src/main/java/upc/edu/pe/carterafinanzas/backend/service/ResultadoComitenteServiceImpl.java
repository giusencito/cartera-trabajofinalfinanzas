package upc.edu.pe.carterafinanzas.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import upc.edu.pe.carterafinanzas.backend.domain.model.entity.ResultadoComitente;
import upc.edu.pe.carterafinanzas.backend.domain.repository.ResultadoComitenteRepository;
import upc.edu.pe.carterafinanzas.backend.domain.service.ResultadoComitenteService;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceNotFoundException;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ResultadoComitenteServiceImpl implements ResultadoComitenteService {





    private static final String ENTITY = "ResultadoComitente";

    private final ResultadoComitenteRepository resultadoComitenteRepository;

    private final Validator validator;

    public ResultadoComitenteServiceImpl( ResultadoComitenteRepository resultadoComitenteRepository,Validator validator){

        this.resultadoComitenteRepository=resultadoComitenteRepository;
        this.validator=validator;


    }

    public List<ResultadoComitente> getAll() {
        return resultadoComitenteRepository.findAll();
    }
    @Override
    public Page<ResultadoComitente> getAll(Pageable pageable) {
        return resultadoComitenteRepository.findAll(pageable);
    }
    @Override
    public ResultadoComitente getById(Long userid) {
        return resultadoComitenteRepository.findById(userid)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, userid));
    }

    @Override
    public ResultadoComitente create(ResultadoComitente request) {
        Set<ConstraintViolation<ResultadoComitente>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return resultadoComitenteRepository.save(request);
    }

    @Override
    public ResultadoComitente update(Long userId, ResultadoComitente request) {

        Set<ConstraintViolation<ResultadoComitente>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return resultadoComitenteRepository.findById(userId).map(user ->
                resultadoComitenteRepository.save(
                        user.withTotalabono(request.getTotalabono())
                                .withTotalcargos(request.getTotalcargos())


                )


        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, userId));





    }

    @Override
    public ResponseEntity<?> delete(Long userid) {
        return resultadoComitenteRepository.findById(userid).map(post -> {
            resultadoComitenteRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, userid));
    }
























































}
