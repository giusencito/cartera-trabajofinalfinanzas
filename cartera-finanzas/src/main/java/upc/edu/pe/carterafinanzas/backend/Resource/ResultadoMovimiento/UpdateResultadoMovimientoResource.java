package upc.edu.pe.carterafinanzas.backend.Resource.ResultadoMovimiento;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateResultadoMovimientoResource {


    private Long id;

    private Double totalcargo;


    private Double totalbono;

    private Double totalsaldo;


}
