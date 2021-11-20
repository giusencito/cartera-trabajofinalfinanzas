package upc.edu.pe.carterafinanzas.backend.Resource.Monto_Financiar;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class CreateMonto_FinanciarResource {


    @NotNull
    private Double resultado;

    @NotNull
    private Double tasa;

    @NotNull
    private Double comision;

    @NotNull
    private Double monto_desenvolsar;


    @NotNull
    private Integer tiempo;












}
