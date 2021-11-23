package upc.edu.pe.carterafinanzas.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Valor;
import upc.edu.pe.carterafinanzas.backend.domain.repository.ValorRepository;
import upc.edu.pe.carterafinanzas.backend.domain.service.ValorService;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceNotFoundException;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceValidationException;

import org.springframework.transaction.annotation.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;
import java.util.Optional;


@Service
public class ValorServiceImpl implements ValorService {

    private ValorRepository valorRepository;

    @Override
    @Transactional
    public boolean grabar(Valor valor) {
        Valor objValor = valorRepository.save(valor);
        if(objValor == null)
            return false;
        else
            return true;
    }

    @Override
    @Transactional
    public void eliminar(Long idValor) {
        valorRepository.deleteById(idValor);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Valor> listarId(Long idValor) {
        return valorRepository.findById(idValor);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Valor> listar() {
        return valorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Valor> buscarValor(String valor){
        return valorRepository.buscarValor(valor);
    }

}
