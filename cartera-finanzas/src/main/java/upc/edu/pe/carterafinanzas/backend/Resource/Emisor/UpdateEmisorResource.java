package upc.edu.pe.carterafinanzas.backend.Resource.Emisor;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Setter
@Getter
public class UpdateEmisorResource {

    private Long id;

    @Size(max = 30)
    private String EmisorNombre;








}
