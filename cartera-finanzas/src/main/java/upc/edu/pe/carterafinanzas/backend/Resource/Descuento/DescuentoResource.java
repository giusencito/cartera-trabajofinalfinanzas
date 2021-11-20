package upc.edu.pe.carterafinanzas.backend.Resource.Descuento;

import lombok.Getter;
import lombok.Setter;
import upc.edu.pe.carterafinanzas.backend.Resource.Emisor.EmisorResource;
import upc.edu.pe.carterafinanzas.backend.Resource.TipoMoneda.TipoMonedaResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Valor.ValorResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Emisor;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.TipoMoneda;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Valor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
public class DescuentoResource {

    private Long id;


    private Date Fecha;


    private Date vencimiento;


    private Double valorMN;


    private Double valorME;



    private double montofinanciar;


    private ValorResource valor;

    private TipoMonedaResource tipoMoneda;


    private EmisorResource emisor;


}
