package upc.edu.pe.carterafinanzas.backend.domain.service;

import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Calculo;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Valor;

import java.util.List;
import java.util.Optional;

public interface CalculoService {

    public Long TasaSimple(Calculo c);
    public Long TasaSimple2(Calculo c);
    public Long TasaNominal(Calculo c);
    public Long TasaNominal2(Calculo c);
    public Long TasaNominal3(Calculo c);
    public Long TasaEfectiva(Calculo c);
}
