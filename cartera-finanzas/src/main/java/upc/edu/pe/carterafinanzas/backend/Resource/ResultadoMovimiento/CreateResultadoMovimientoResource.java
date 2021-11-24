package upc.edu.pe.carterafinanzas.backend.Resource.ResultadoMovimiento;



import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateResultadoMovimientoResource {



    @NotNull
    private Double totalcargo;


    private Double totalbono;

    @NotNull
    private Double totalsaldo;








}
