package upc.edu.pe.carterafinanzas.backend.Resource.Cartera;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
public class CreateCarteraResource {

    @NotNull
    private Double valormntotal;

    @NotNull
    private Double valormetotal;


    private Double valorgarantiatotal;

    @NotNull
    private Double Tipodecambio;

    @NotNull
    private Date Fecha;









}
