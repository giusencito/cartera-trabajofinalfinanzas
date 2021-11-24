package upc.edu.pe.carterafinanzas.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.ResultadoComitente;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.ResultadoMovimiento;
import upc.edu.pe.carterafinanzas.backend.domain.repository.ResultadoMovimientoRepository;
import upc.edu.pe.carterafinanzas.backend.domain.service.ResultadoMovimientoService;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceNotFoundException;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ResultadoMovimientoServiceImpl implements ResultadoMovimientoService {




@Autowired
    private  ResultadoMovimientoRepository resultadoMovimientoRepository;



    @Override
    @Transactional
    public boolean grabar(ResultadoMovimiento resultadoMovimiento) {

        ResultadoMovimiento objActividad = resultadoMovimientoRepository.save(resultadoMovimiento);
        if(objActividad == null)
            return false;
        else
            return true;


    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        resultadoMovimientoRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ResultadoMovimiento> listarId(Long id) {
        return resultadoMovimientoRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ResultadoMovimiento> listar() {
        return resultadoMovimientoRepository.findAll();
    }
















































}
