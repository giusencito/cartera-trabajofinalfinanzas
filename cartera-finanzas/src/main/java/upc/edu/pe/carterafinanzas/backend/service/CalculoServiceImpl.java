package upc.edu.pe.carterafinanzas.backend.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Calculo;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Valor;
import upc.edu.pe.carterafinanzas.backend.domain.repository.ValorRepository;
import upc.edu.pe.carterafinanzas.backend.domain.service.CalculoService;

import java.util.List;
import java.util.Optional;


@Service
public class CalculoServiceImpl implements CalculoService {


    @Override
    @Transactional
    public Long TasaSimple(Calculo c) {
        Long interes;
        switch (c.getPeriodoTasa()){
            case "Diaria": interes=(Long)(c.getCapital()*(c.getTasadeInteres()/100)*((c.getTiempo())/360));
                            break;
            case "Quincenal": break;
            case "Mensual": break;
            case "Bimestral": break;
            case "Trimestral": break;
            case "Semestral": break;
            case "Anual": break;

        }
        return interes;
    }

    @Override
    @Transactional
    public Long TasaSimple2(Calculo c) {
        return null;
    }

    @Override
    @Transactional
    public Long TasaNominal(Calculo c) {
        return null;
    }

    @Override
    @Transactional
    public Long TasaNominal2(Calculo c) {
        return null;
    }

    @Override
    @Transactional
    public Long TasaNominal3(Calculo c) {
        return null;
    }

    @Override
    @Transactional
    public Long TasaEfectiva(Calculo c) {
        return null;
    }
}
