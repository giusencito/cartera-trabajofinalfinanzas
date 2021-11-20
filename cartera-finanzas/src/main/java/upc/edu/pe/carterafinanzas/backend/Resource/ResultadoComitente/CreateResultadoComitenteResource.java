package upc.edu.pe.carterafinanzas.backend.Resource.ResultadoComitente;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class CreateResultadoComitenteResource {


    @NotNull
    private Double totalabono;


    private Double totalcargos;








}
