package upc.edu.pe.carterafinanzas.backend.Resource.Emisor;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
public class CreateEmisorResource {



    @NotNull
    @NotBlank
    @Size(max = 30)
    private String EmisorNombre;










}
