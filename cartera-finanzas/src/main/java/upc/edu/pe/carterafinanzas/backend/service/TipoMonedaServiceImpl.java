package upc.edu.pe.carterafinanzas.backend.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.TipoMoneda;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Usuario;
import upc.edu.pe.carterafinanzas.backend.domain.repository.TipoMonedaRepository;
import upc.edu.pe.carterafinanzas.backend.domain.service.TipoMonedaService;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceNotFoundException;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class TipoMonedaServiceImpl implements TipoMonedaService {

    @Autowired
    private TipoMonedaRepository dTipoMoneda;

    @Override
    @Transactional
    public boolean grabar(TipoMoneda tipomoneda) {
        TipoMoneda objTipoMoneda = dTipoMoneda.save(tipomoneda);
        if (objTipoMoneda == null)
            return false;
        else
            return true;
    }


    @Override
    @Transactional
    public void eliminar(Long idTipoMoneda) {
        dTipoMoneda.deleteById(idTipoMoneda);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TipoMoneda> listarId(Long idTipoMoneda) {
        return dTipoMoneda.findById(idTipoMoneda);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoMoneda> listar() {
        return dTipoMoneda.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TipoMoneda> buscarTipoMoneda(String nombre){
        return dTipoMoneda.buscarTipoMoneda(nombre);
    }
}
