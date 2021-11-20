package upc.edu.pe.carterafinanzas.backend.Resource.Monto_Financiar;


import lombok.Getter;
import lombok.Setter;
import upc.edu.pe.carterafinanzas.backend.Resource.Descuento.DescuentoResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Descuento;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class Monto_FinanciarResource {
    private Long id;



    private Double resultado;


    private Double tasa;


    private Double comision;


    private Double monto_desenvolsar;



    private Integer tiempo;

    private DescuentoResource descuento;



}
