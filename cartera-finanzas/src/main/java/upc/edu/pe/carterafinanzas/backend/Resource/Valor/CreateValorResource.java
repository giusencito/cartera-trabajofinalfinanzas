package upc.edu.pe.carterafinanzas.backend.Resource.Valor;




import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class CreateValorResource {



    @NotNull
    @NotBlank
    @Size(max = 30)
    private String ValorNombre;






}
