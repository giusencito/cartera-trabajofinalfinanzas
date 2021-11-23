package upc.edu.pe.carterafinanzas.backend.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.*;
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
import java.util.Optional;
import java.util.Set;

@Service
public class ComitenteServiceImpl implements ComitenteService {

    private ComitenteRepository comitenteRepository;

    @Override
    @Transactional
    public boolean grabar(Comitente comitente){
        Comitente objComitente = comitenteRepository.save(comitente);
        if(objComitente == null)
            return false;
        else
            return true;
    }

    @Override
    @Transactional
    public void eliminar(Long idComitente) {
        comitenteRepository.deleteById(idComitente);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Comitente> listarId(Long idComitente) {
        return comitenteRepository.findById(idComitente);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comitente> listar() {
        return comitenteRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Comitente> buscarResultadoComitente(Long id) {
        return comitenteRepository.buscarResultadoComitente(id);
    }

}
