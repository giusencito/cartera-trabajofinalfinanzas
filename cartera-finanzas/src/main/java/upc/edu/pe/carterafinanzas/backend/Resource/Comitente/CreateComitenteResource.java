package upc.edu.pe.carterafinanzas.backend.Resource.Comitente;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
@Setter
@Getter
public class CreateComitenteResource {

    @NotNull
    private Date Fecha;

    @NotNull
    private Double cargo;

    @NotNull
    private Double abono;
}
