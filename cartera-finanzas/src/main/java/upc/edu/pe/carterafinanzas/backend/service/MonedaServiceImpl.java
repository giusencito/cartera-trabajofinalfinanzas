package upc.edu.pe.carterafinanzas.backend.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import upc.edu.pe.carterafinanzas.backend.domain.model.entity.*;
import upc.edu.pe.carterafinanzas.backend.domain.repository.*;
import upc.edu.pe.carterafinanzas.backend.domain.service.MonedaService;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceNotFoundException;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class MonedaServiceImpl implements MonedaService {


    private static final String ENTITY = "Moneda";
    private final MonedaRepository monedaRepository;
    private final EmisorRepository emisorRepository;
    private final ValorRepository valorRepository;
    private final TipoMonedaRepository tipoMonedaRepository;
    private final CarteraRepository carteraRepository;
    private final Validator validator;
    public MonedaServiceImpl(MonedaRepository monedaRepository,EmisorRepository emisorRepository,ValorRepository valorRepository,TipoMonedaRepository tipoMonedaRepository,CarteraRepository carteraRepository
    ,Validator validator
    ){
        this.monedaRepository=monedaRepository;
        this.emisorRepository=emisorRepository;
        this.valorRepository=valorRepository;
        this.tipoMonedaRepository=tipoMonedaRepository;
        this.carteraRepository=carteraRepository;
        this.validator=validator;
    }
    public List<Moneda> getAll() {
        return monedaRepository.findAll();
    }

    @Override
    public Page<Moneda> getAll(Pageable pageable) {
        return monedaRepository.findAll(pageable);
    }

    @Override
    public Moneda getById(Long MonedaId) {
        return monedaRepository.findById(MonedaId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, MonedaId));
    }

    @Override
    public Moneda create(Long emisorId, Long valorId,Long tipodemonedaId,Long carteraId, Moneda request) {
        Emisor user = emisorRepository.findById(emisorId)
                .orElseThrow(() -> new ResourceNotFoundException("Emisor", emisorId));
        TipoMoneda g=tipoMonedaRepository.findById(tipodemonedaId)
                .orElseThrow(()-> new ResourceNotFoundException("TipoMoneda", tipodemonedaId));
        Cartera c=carteraRepository.findById(carteraId)
                .orElseThrow(()-> new ResourceNotFoundException("Cartera", carteraId));
        return valorRepository.findById(valorId)
                .map(publications -> {
                    request.setValor(publications);
                    request.setEmisor(user);
                    request.setTipoMoneda(g);
                    request.setCartera(c);
                    return monedaRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Valor", valorId));
    }
    @Override
    public Moneda update(Long MonedaId, Moneda request) {
        Set<ConstraintViolation<Moneda>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return monedaRepository.findById(MonedaId).map(event ->
                monedaRepository.save(
                        event
                                .withValorMN(request.getValorMN())
                                .withValorME(request.getValorME())
                                .withGarantia(request.getGarantia())
                )

        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, MonedaId));
    }


    @Override
    public ResponseEntity<?> delete(Long MonedaId) {
        return monedaRepository.findById(MonedaId).map(post -> {
            monedaRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, MonedaId));
    }

    @Override
    public List<Moneda> findByemisorId(Long publicationId) {
        return monedaRepository.findByemisorId(publicationId);
    }
    @Override
    public List<Moneda> findByvalorId(Long publicationId) {
        return monedaRepository.findByvalorId(publicationId);
    }
    @Override
    public List<Moneda> findBytipodemonedaId(Long publicationId) {
        return monedaRepository.findBytipodemonedaId(publicationId);
    }

    @Override
    public List<Moneda> findByCarteraId(Long publicationId) {
        return monedaRepository.findByCarteraId(publicationId);
    }































}
