package upc.edu.pe.carterafinanzas.backend.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Emisor;
import upc.edu.pe.carterafinanzas.backend.domain.repository.EmisorRepository;
import upc.edu.pe.carterafinanzas.backend.domain.service.EmisorService;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceNotFoundException;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceValidationException;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class EmisorServiceImpl implements EmisorService {


    private static final String ENTITY = "Emisor";

    private final EmisorRepository emisorRepository;

    private final Validator validator;

    public EmisorServiceImpl(EmisorRepository emisorRepository,Validator validator){

        this.emisorRepository=emisorRepository;
        this.validator=validator;


    }

    public List<Emisor> getAll() {
        return emisorRepository.findAll();
    }
    @Override
    public Page<Emisor> getAll(Pageable pageable) {
        return emisorRepository.findAll(pageable);
    }
    @Override
    public Emisor getById(Long userid) {
        return emisorRepository.findById(userid)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, userid));
    }

    @Override
    public Emisor create(Emisor request) {
        Set<ConstraintViolation<Emisor>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return emisorRepository.save(request);
    }

    @Override
    public Emisor update(Long userId, Emisor request) {

        Set<ConstraintViolation<Emisor>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return emisorRepository.findById(userId).map(user ->
                emisorRepository.save(
                                user.withEmisorNombre(request.getEmisorNombre())

                )


        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, userId));





    }

    @Override
    public ResponseEntity<?> delete(Long userid) {
        return emisorRepository.findById(userid).map(post -> {
            emisorRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, userid));
    }









}
