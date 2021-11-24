package upc.edu.pe.carterafinanzas.backend.Resource.Moneda;

import lombok.Getter;
import lombok.Setter;
import upc.edu.pe.carterafinanzas.backend.Resource.Cartera.CarteraResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Emisor.EmisorResource;
import upc.edu.pe.carterafinanzas.backend.Resource.TipoMoneda.TipoMonedaResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Valor.ValorResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Cartera;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Emisor;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.TipoMoneda;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Valor;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class MonedaResource {

    private Long id;



    private Double valorMN;


    private Double valorME;



    private Double garantia;



    private ValorResource valor;

    private TipoMonedaResource tipoMoneda;

    private EmisorResource emisor;

    private CarteraResource cartera;




}
