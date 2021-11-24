package upc.edu.pe.carterafinanzas.backend.domain.service;

import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Calculo;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Valor;

import java.util.List;
import java.util.Optional;

public interface CalculoService {

    public double TasaSimple(Calculo c);
    public double TasaSimple2(Calculo c);
    public double TasaNominal(Calculo c);
    public double TasaNominal2(Calculo c);
    public double TasaNominal3(Calculo c);
    public double TasaEfectiva(Calculo c);
}
