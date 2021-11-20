package upc.edu.pe.carterafinanzas.backend.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Moneda;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Monto_Financiar;

import upc.edu.pe.carterafinanzas.backend.domain.repository.DescuentoRepository;
import upc.edu.pe.carterafinanzas.backend.domain.repository.Monto_FinanciarRepository;
import upc.edu.pe.carterafinanzas.backend.domain.service.Monto_FinanciarService;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceNotFoundException;
import upc.edu.pe.carterafinanzas.shared.exception.ResourceValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class Monto_FinanciarServiceImpl implements Monto_FinanciarService {


    private static final String ENTITY = "Moneda";
    private final Monto_FinanciarRepository monto_financiarRepository;
    private final DescuentoRepository descuentoRepository;
    private final Validator validator;
    public  Monto_FinanciarServiceImpl(Monto_FinanciarRepository monto_financiarRepository,DescuentoRepository descuentoRepository,Validator validator){

        this.monto_financiarRepository=monto_financiarRepository;
        this.descuentoRepository=descuentoRepository;
        this.validator=validator;








    }

    public List<Monto_Financiar> getAll() {
        return monto_financiarRepository.findAll();
    }

    @Override
    public Page<Monto_Financiar> getAll(Pageable pageable) {
        return monto_financiarRepository.findAll(pageable);
    }

    @Override
    public Monto_Financiar getById(Long Monto_FinanciarId) {
        return monto_financiarRepository.findById(Monto_FinanciarId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, Monto_FinanciarId));
    }

    @Override
    public Monto_Financiar create(Long DescuentoId, Monto_Financiar request) {

        return descuentoRepository.findById(DescuentoId)
                .map(publications -> {
                    request.setDescuento(publications);

                    return monto_financiarRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Descuento", DescuentoId));
    }


    @Override
    public Monto_Financiar update(Long Monto_FinanciarId, Monto_Financiar request) {

        Set<ConstraintViolation<Monto_Financiar>> violations = validator.validate(request);
        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return monto_financiarRepository.findById(Monto_FinanciarId).map(user ->
                monto_financiarRepository.save(
                        user.withResultado(request.getResultado())
                                .withTasa(request.getTasa())
                                .withTiempo(request.getTiempo())
                                .withComision(request.getComision())
                                .withMonto_desenvolsar(request.getMonto_desenvolsar())

                )


        ).orElseThrow(() -> new ResourceNotFoundException(ENTITY, Monto_FinanciarId));





    }

    @Override
    public ResponseEntity<?> delete(Long Monto_FinanciarId) {
        return monto_financiarRepository.findById(Monto_FinanciarId).map(post -> {
            monto_financiarRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, Monto_FinanciarId));
    }


    @Override
    public List<Monto_Financiar> findBydescuentoID(Long publicationId) {
        return monto_financiarRepository.findBydescuentoID(publicationId);
    }















}
