package upc.edu.pe.carterafinanzas.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import upc.edu.pe.carterafinanzas.backend.domain.model.entity.ResultadoMovimiento;
import upc.edu.pe.carterafinanzas.backend.domain.repository.ResultadoMovimientoRepository;
import upc.edu.pe.carterafinanzas.backend.domain.service.ResultadoMovimientoService;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceNotFoundException;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ResultadoMovimientoServiceImpl implements ResultadoMovimientoService {



    private static final String ENTITY = "ResultadoMovimiento";

    private final ResultadoMovimientoRepository resultadoMovimientoRepository;

    private final Validator validator;

    public ResultadoMovimientoServiceImpl(ResultadoMovimientoRepository resultadoMovimientoRepository,Validator validator){

        this.resultadoMovimientoRepository=resultadoMovimientoRepository;
        this.validator=validator;


    }

    public List<ResultadoMovimiento> getAll() {
        return resultadoMovimientoRepository.findAll();
    }
    @Override
    public Page<ResultadoMovimiento> getAll(Pageable pageable) {
        return resultadoMovimientoRepository.findAll(pageable);
    }
    @Override
    public ResultadoMovimiento getById(Long userid) {
        return resultadoMovimientoRepository.findById(userid)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, userid));
    }

    @Override
    public ResultadoMovimiento create(ResultadoMovimiento request) {
        Set<ConstraintViolation<ResultadoMovimiento>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return resultadoMovimientoRepository.save(request);
    }

    @Override
    public ResultadoMovimiento update(Long userId, ResultadoMovimiento request) {

        Set<ConstraintViolation<ResultadoMovimiento>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return resultadoMovimientoRepository.findById(userId).map(user ->
                resultadoMovimientoRepository.save(
                        user    .withTotalbono(request.getTotalbono())
                                .withTotalcargo(request.getTotalcargo())
                                .withTotalsaldo(request.getTotalsaldo())


                )


        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, userId));





    }

    @Override
    public ResponseEntity<?> delete(Long userid) {
        return resultadoMovimientoRepository.findById(userid).map(post -> {
            resultadoMovimientoRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, userid));
    }

















































}
