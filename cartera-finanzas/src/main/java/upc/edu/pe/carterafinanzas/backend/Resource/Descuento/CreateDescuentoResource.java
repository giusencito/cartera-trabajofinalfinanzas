package upc.edu.pe.carterafinanzas.backend.Resource.Descuento;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
public class CreateDescuentoResource {



    @NotNull
    private Date Fecha;

    @NotNull
    private Date vencimiento;

    @NotNull
    private Double valorMN;

    @NotNull
    private Double valorME;



    private double montofinanciar;















}
