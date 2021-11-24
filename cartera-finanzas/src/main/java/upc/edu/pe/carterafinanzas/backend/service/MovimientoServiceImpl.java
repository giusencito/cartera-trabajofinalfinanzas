package upc.edu.pe.carterafinanzas.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Descuento;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Emisor;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Movimiento;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.TipoMoneda;
import upc.edu.pe.carterafinanzas.backend.domain.repository.MovimientoRepository;

import upc.edu.pe.carterafinanzas.backend.domain.repository.ResultadoMovimientoRepository;
import upc.edu.pe.carterafinanzas.backend.domain.repository.TipoMonedaRepository;
import upc.edu.pe.carterafinanzas.backend.domain.service.MovimientoService;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceNotFoundException;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MovimientoServiceImpl implements MovimientoService {


   @Autowired
    private  MovimientoRepository movimientoRepository;



    @Override
    @Transactional
    public boolean grabar(Movimiento movimiento) {
        Movimiento objMensaje = movimientoRepository.save(movimiento);
        if(objMensaje == null)
            return false;
        else
            return true;
    }


    @Override
    @Transactional
    public void eliminar(Long idMensaje) {
        movimientoRepository.deleteById(idMensaje);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Movimiento> listarId(Long idMensaje) {
        return movimientoRepository.findById(idMensaje);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movimiento> listar() {
        return movimientoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Movimiento> buscarnoneda(String moneda) {
        return movimientoRepository.buscartipomoneda(moneda);
    }


    @Override
    @Transactional(readOnly = true)
    public List<Movimiento> buscarresultadomovimiento(Long moneda) {
        return movimientoRepository.buscarAnio(moneda);
    }













































}
