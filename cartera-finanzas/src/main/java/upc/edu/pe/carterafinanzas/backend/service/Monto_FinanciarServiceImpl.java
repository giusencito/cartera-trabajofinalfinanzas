package upc.edu.pe.carterafinanzas.backend.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Moneda;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Monto_Financiar;

import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Valor;
import upc.edu.pe.carterafinanzas.backend.domain.repository.DescuentoRepository;
import upc.edu.pe.carterafinanzas.backend.domain.repository.Monto_FinanciarRepository;
import upc.edu.pe.carterafinanzas.backend.domain.service.Monto_FinanciarService;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceNotFoundException;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceValidationException;
import org.springframework.transaction.annotation.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class Monto_FinanciarServiceImpl implements Monto_FinanciarService {

    private Monto_FinanciarRepository monto_financiarRepository;

    @Override
    @Transactional
    public boolean grabar(Monto_Financiar monto){
        Monto_Financiar objMonto = monto_financiarRepository.save(monto);
        if(objMonto == null)
            return false;
        else
            return true;
    }

    @Override
    @Transactional
    public void eliminar(int idMonto) {
        monto_financiarRepository.deleteById(idMonto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Monto_Financiar> listarId(int idMonto) {
        return monto_financiarRepository.findById(idMonto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Monto_Financiar> listar() {
        return monto_financiarRepository.findAll();
    }

    /*
    @Override
    @Transactional(readOnly = true)
    public List<Monto_Financiar> buscarMonto(Double resultado){
        return monto_financiarRepository.buscarMonto(resultado);
    }*/

}
