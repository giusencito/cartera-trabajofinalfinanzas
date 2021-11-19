package upc.edu.pe.carterafinanzas.backend.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Descuento;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Emisor;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.TipoMoneda;
import upc.edu.pe.carterafinanzas.backend.domain.repository.*;
import upc.edu.pe.carterafinanzas.backend.domain.service.DescuentoService;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceNotFoundException;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceValidationException;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;



@Service
public class DescuentoServiceImpl implements DescuentoService {



    private static final String ENTITY = "Descuento";

    private final DescuentoRepository descuentoRepository;
    private final EmisorRepository emisorRepository;
    private final ValorRepository valorRepository;
    private final TipoMonedaRepository tipoMonedaRepository;
    private final Validator validator;
    public DescuentoServiceImpl(DescuentoRepository descuentoRepository, EmisorRepository emisorRepository, TipoMonedaRepository tipoMonedaRepository, ValorRepository valorRepository, Validator validator){

        this.descuentoRepository=descuentoRepository;
        this.emisorRepository = emisorRepository;
        this.valorRepository = valorRepository;
        this.tipoMonedaRepository=tipoMonedaRepository;
        this.validator=validator;
    }
    public List<Descuento> getAll() {
        return descuentoRepository.findAll();
    }

    @Override
    public Page<Descuento> getAll(Pageable pageable) {
        return descuentoRepository.findAll(pageable);
    }
    @Override
    public Descuento getById(Long DescuentoId) {
        return descuentoRepository.findById(DescuentoId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, DescuentoId));
    }

    @Override
    public Descuento create(Long emisorId, Long valorId,Long tipodemonedaId, Descuento request) {
        Emisor user = emisorRepository.findById(emisorId)
                .orElseThrow(() -> new ResourceNotFoundException("Emisor", emisorId));
        TipoMoneda g=tipoMonedaRepository.findById(tipodemonedaId)
                .orElseThrow(()-> new ResourceNotFoundException("TipoMoneda", tipodemonedaId));
        return valorRepository.findById(valorId)
                .map(publications -> {
                    request.setValor(publications);
                    request.setEmisor(user);
                    request.setTipoMoneda(g);
                    return descuentoRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Valor", valorId));
    }

    @Override
    public Descuento update(Long DescuentoId, Descuento request) {
        Set<ConstraintViolation<Descuento>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return descuentoRepository.findById(DescuentoId).map(event ->
                descuentoRepository.save(
                        event
                                .withFecha(request.getFecha())
                                .withVencimiento(request.getVencimiento())
                                .withValorMN(request.getValorMN())
                                .withValorME(request.getValorME())
                                .withMontofinanciar(request.getMontofinanciar())
                )

        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, DescuentoId));
    }


    @Override
    public ResponseEntity<?> delete(Long DescuentoId) {
        return descuentoRepository.findById(DescuentoId).map(post -> {
            descuentoRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, DescuentoId));
    }

    @Override
    public List<Descuento> findByemisorId(Long publicationId) {
        return descuentoRepository.findByemisorId(publicationId);
    }
    @Override
    public List<Descuento> findByValorId(Long publicationId) {
        return descuentoRepository.findByValorId(publicationId);
    }
    @Override
    public List<Descuento> findBytipodemonedaId(Long publicationId) {
        return descuentoRepository.findBytipodemonedaId(publicationId);
    }









}
