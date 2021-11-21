package upc.edu.pe.carterafinanzas.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;


import upc.edu.pe.carterafinanzas.backend.domain.model.entity.ResultadoComitente;
import upc.edu.pe.carterafinanzas.backend.domain.repository.ResultadoComitenteRepository;
import upc.edu.pe.carterafinanzas.backend.domain.service.ResultadoComitenteService;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceNotFoundException;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ResultadoComitenteServiceImpl implements ResultadoComitenteService {






    @Autowired
    private  ResultadoComitenteRepository resultadoComitenteRepository;

    @Override
    @Transactional
    public boolean grabar(ResultadoComitente resultadoComitente) {

        ResultadoComitente objActividad = resultadoComitenteRepository.save(resultadoComitente);
        if(objActividad == null)
            return false;
        else
            return true;


    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        resultadoComitenteRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ResultadoComitente> listarId(Long id) {
        return resultadoComitenteRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResultadoComitente> listar() {
        return resultadoComitenteRepository.findAll();
    }





















































}
