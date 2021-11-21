package upc.edu.pe.carterafinanzas.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Cartera;
import upc.edu.pe.carterafinanzas.backend.domain.repository.CarteraRepository;
import upc.edu.pe.carterafinanzas.backend.domain.repository.UsuarioRepository;
import upc.edu.pe.carterafinanzas.backend.domain.service.CarteraService;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceNotFoundException;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CarteraServiceImpl implements CarteraService {


    @Autowired
    private CarteraRepository dCartera;

    @Override
    @Transactional
    public boolean grabar(Cartera cartera) {
        Cartera objCartera = dCartera.save(cartera);
        if (objCartera == null)
            return false;
        else
            return true;
    }


    @Override
    @Transactional
    public void eliminar(Long idCartera) {
        dCartera.deleteById(idCartera);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Cartera> listarId(Long idCartera) {
        return dCartera.findById(idCartera);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cartera> listar() {
        return dCartera.findAll();
    }

    public List<Cartera> findByUsuarioId(Long usuarioId){
        return dCartera.findByUsuarioId(usuarioId);

    }

}
