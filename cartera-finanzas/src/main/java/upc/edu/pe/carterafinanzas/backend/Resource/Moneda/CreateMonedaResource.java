package upc.edu.pe.carterafinanzas.backend.Resource.Moneda;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class CreateMonedaResource {


    @NotNull
    private Double valorMN;

    @NotNull
    private Double valorME;



    private Double garantia;


















}
