package upc.edu.pe.carterafinanzas.backend.Resource.TipoMoneda;



import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
public class CreateTipoMonedaResource {



    @NotNull
    @NotBlank
    @Size(max = 30)
    private String NombreMoneda;





}
