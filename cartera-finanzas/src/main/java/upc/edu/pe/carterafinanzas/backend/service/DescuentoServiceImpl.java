package upc.edu.pe.carterafinanzas.backend.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Descuento;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Emisor;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Monto_Financiar;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.TipoMoneda;
import upc.edu.pe.carterafinanzas.backend.domain.repository.*;
import upc.edu.pe.carterafinanzas.backend.domain.service.DescuentoService;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceNotFoundException;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceValidationException;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Optional;
import java.util.Set;



@Service
public class DescuentoServiceImpl implements DescuentoService {

    private DescuentoRepository descuentoRepository;

    @Override
    @Transactional
    public boolean grabar(Descuento descuento){
        Descuento objDescuento = descuentoRepository.save(descuento);
        if(objDescuento == null)
            return false;
        else
            return true;
    }

    @Override
    @Transactional
    public void eliminar(int idDescuento) {
        descuentoRepository.deleteById(idDescuento);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Descuento> listarId(int idDescuento) {
        return descuentoRepository.findById(idDescuento);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Descuento> listar() {
        return descuentoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Descuento> buscarDescuentoMN(Double resultado){
        return descuentoRepository.buscarDescuentoMN(resultado);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Descuento> buscarDescuentoME(Double resultado){
        return descuentoRepository.buscarDescuentoME(resultado);
    }
}
