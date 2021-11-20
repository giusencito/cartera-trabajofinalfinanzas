package upc.edu.pe.carterafinanzas.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Descuento;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Movimiento;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.TipoMoneda;
import upc.edu.pe.carterafinanzas.backend.domain.repository.MovimientoRepository;

import upc.edu.pe.carterafinanzas.backend.domain.repository.ResultadoMovimientoRepository;
import upc.edu.pe.carterafinanzas.backend.domain.repository.TipoMonedaRepository;
import upc.edu.pe.carterafinanzas.backend.domain.service.MovimientoService;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceNotFoundException;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class MovimientoServiceImpl implements MovimientoService {


    private static final String ENTITY = "Movimiento";
    private final MovimientoRepository movimientoRepository;
    private final TipoMonedaRepository tipoMonedaRepository;
    private final ResultadoMovimientoRepository resultadoMovimientoRepository;
    private final Validator validator;
    public MovimientoServiceImpl(MovimientoRepository movimientoRepository,TipoMonedaRepository tipoMonedaRepository,ResultadoMovimientoRepository resultadoMovimientoRepository
    ,Validator validator
    ){
        this.movimientoRepository=movimientoRepository;
        this.tipoMonedaRepository=tipoMonedaRepository;
        this.resultadoMovimientoRepository=resultadoMovimientoRepository;
        this.validator=validator;




    }

    public List<Movimiento> getAll() {
        return movimientoRepository.findAll();
    }

    @Override
    public Page<Movimiento> getAll(Pageable pageable) {
        return movimientoRepository.findAll(pageable);
    }

    @Override
    public Movimiento getById(Long MovimientoId) {
        return movimientoRepository.findById(MovimientoId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, MovimientoId));
    }
    @Override
    public Movimiento create(Long tipodemonedaId,Long ResultadoMovimientoId, Movimiento request) {

        TipoMoneda g=tipoMonedaRepository.findById(tipodemonedaId)
                .orElseThrow(()-> new ResourceNotFoundException("TipoMoneda", tipodemonedaId));
        return resultadoMovimientoRepository.findById(ResultadoMovimientoId)
                .map(publications -> {
                    request.setResultadoMovimiento(publications);

                    request.setTipoMoneda(g);
                    return movimientoRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException("ResultadoMovimiento", ResultadoMovimientoId));
    }


    @Override
    public Movimiento update(Long MovimientoId, Movimiento request) {
        Set<ConstraintViolation<Movimiento>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return movimientoRepository.findById(MovimientoId).map(event ->
                movimientoRepository.save(
                        event
                                .withFecha(request.getFecha())
                                .withFechaValor(request.getFechaValor())
                                .withDescripcion(request.getDescripcion())
                                .withCargo(request.getCargo())
                                .withAbono(request.getAbono())
                                .withSaldo(request.getSaldo())
                )

        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, MovimientoId));
    }

    @Override
    public ResponseEntity<?> delete(Long MovimientoId) {
        return movimientoRepository.findById(MovimientoId).map(post -> {
            movimientoRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, MovimientoId));
    }

    @Override
    public List<Movimiento> findBytipodemonedaId(Long publicationId) {
        return movimientoRepository.findBytipodemonedaId(publicationId);
    }
    @Override
    public List<Movimiento> findByResultadoMovimientoId(Long publicationId) {
        return movimientoRepository.findByResultadoMovimientoId(publicationId);
    }
























































}
