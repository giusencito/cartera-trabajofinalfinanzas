package upc.edu.pe.carterafinanzas.backend.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Emisor;
import upc.edu.pe.carterafinanzas.backend.domain.repository.EmisorRepository;
import upc.edu.pe.carterafinanzas.backend.domain.service.EmisorService;
import org.springframework.transaction.annotation.Transactional;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceNotFoundException;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceValidationException;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.List;
import java.util.Optional;
@Service
public class EmisorServiceImpl implements EmisorService {



    @Autowired
    private  EmisorRepository emisorRepository;

    @Override
    @Transactional
    public boolean grabar(Emisor emisor) {

            Emisor objActividad = emisorRepository.save(emisor);
            if(objActividad == null)
                return false;
            else
                return true;


    }


    @Override
    @Transactional
    public void eliminar(Long id) {
        emisorRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Emisor> listarId(Long id) {
        return emisorRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Emisor> listar() {
        return emisorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Emisor> buscarNombre(String nombre) {
        return emisorRepository.buscarNombre(nombre);
    }






}
