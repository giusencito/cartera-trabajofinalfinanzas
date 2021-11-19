package upc.edu.pe.carterafinanzas.backend.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Comitente;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Emisor;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.ResultadoComitente;
import upc.edu.pe.carterafinanzas.backend.domain.repository.ComitenteRepository;
import upc.edu.pe.carterafinanzas.backend.domain.repository.EmisorRepository;
import upc.edu.pe.carterafinanzas.backend.domain.repository.ResultadoComitenteRepository;
import upc.edu.pe.carterafinanzas.backend.domain.repository.ValorRepository;
import upc.edu.pe.carterafinanzas.backend.domain.service.ComitenteService;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceNotFoundException;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceValidationException;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ComitenteServiceImpl implements ComitenteService {

    private static final String ENTITY = "Comitente";

    private final ComitenteRepository comitenteRepository;
    private final EmisorRepository emisorRepository;
    private final ValorRepository valorRepository;
    private final ResultadoComitenteRepository resultadoComitenteRepository;
    private final Validator validator;


    public ComitenteServiceImpl(ComitenteRepository comitenteRepository, EmisorRepository emisorRepository, ResultadoComitenteRepository resultadoComitenteRepository, ValorRepository valorRepository, Validator validator){

        this.comitenteRepository=comitenteRepository;
        this.emisorRepository = emisorRepository;
        this.valorRepository = valorRepository;
        this.resultadoComitenteRepository=resultadoComitenteRepository;
        this.validator=validator;
    }
    public List<Comitente> getAll() {
        return comitenteRepository.findAll();
    }

    @Override
    public Page<Comitente> getAll(Pageable pageable) {
        return comitenteRepository.findAll(pageable);
    }
    @Override
    public Comitente getById(Long ComitenteId) {
        return comitenteRepository.findById(ComitenteId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, ComitenteId));
    }
    @Override
    public Comitente create(Long emisorId, Long valorId,Long resultadocomitenteId, Comitente request) {
        Emisor user = emisorRepository.findById(emisorId)
                .orElseThrow(() -> new ResourceNotFoundException("Emisor", emisorId));
        ResultadoComitente g=resultadoComitenteRepository.findById(resultadocomitenteId)
                .orElseThrow(()-> new ResourceNotFoundException("ResultadoComitente", resultadocomitenteId));
        return valorRepository.findById(valorId)
                .map(publications -> {
                    request.setValor(publications);
                    request.setEmisor(user);
                    request.setResultadoComitente(g);
                    return comitenteRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Valor", valorId));
    }

    @Override
    public Comitente update(Long ComitenteId, Comitente request) {
        Set<ConstraintViolation<Comitente>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return comitenteRepository.findById(ComitenteId).map(event ->
                comitenteRepository.save(
                        event
                                .withFecha(request.getFecha())
                                .withCargo(request.getCargo())
                                .withAbono(request.getAbono())
                )




        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, ComitenteId));
    }

    @Override
    public ResponseEntity<?> delete(Long comitenteId) {
        return comitenteRepository.findById(comitenteId).map(post -> {
            comitenteRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, comitenteId));
    }
    @Override
    public List<Comitente> findByemisorId(Long emisornId) {
        return comitenteRepository.findByemisorId(emisornId);
    }
    @Override
    public List<Comitente> findByvalorId(Long valorId) {
        return comitenteRepository.findByvalorId(valorId);
    }
    @Override
    public List<Comitente> findByresultadocomitenteId(Long resultadocomitenteId) {
        return comitenteRepository.findByresultadocomitenteId(resultadocomitenteId);
    }




















}
