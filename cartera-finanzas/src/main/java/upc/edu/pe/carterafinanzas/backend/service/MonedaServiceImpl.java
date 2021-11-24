package upc.edu.pe.carterafinanzas.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import upc.edu.pe.carterafinanzas.backend.domain.model.entity.*;
import upc.edu.pe.carterafinanzas.backend.domain.repository.*;
import upc.edu.pe.carterafinanzas.backend.domain.service.MonedaService;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceNotFoundException;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MonedaServiceImpl implements MonedaService {


    @Autowired
    private MonedaRepository dMoneda;

    @Override
    @Transactional
    public boolean grabar(Moneda moneda) {
        Moneda objMoneda = dMoneda.save(moneda);
        if (objMoneda == null)
            return false;
        else
            return true;
    }


    @Override
    @Transactional
    public void eliminar(Long idMoneda) {
        dMoneda.deleteById(idMoneda);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Moneda> listarId(Long idMoneda) {
        return dMoneda.findById(idMoneda);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Moneda> listar() {
        return dMoneda.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Moneda> findByemisorId(Long emisorId){
        return dMoneda.findByemisorId(emisorId);

    }

    @Override
    @Transactional(readOnly = true)
    public List<Moneda> findByvalorId(Long valorId){
        return dMoneda.findByvalorId(valorId);

    }

    @Override
    @Transactional(readOnly = true)
    public List<Moneda> findBytipodemonedaId(Long tipodemonedaId){
        return dMoneda.findBytipodemonedaId(tipodemonedaId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Moneda>findByCarteraId(Long carteraId){
        return dMoneda.findByCarteraId(carteraId);
    }
}
