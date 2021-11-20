package upc.edu.pe.carterafinanzas.backend.Resource.Comitente;

import lombok.Getter;
import lombok.Setter;
import upc.edu.pe.carterafinanzas.backend.Resource.Emisor.EmisorResource;
import upc.edu.pe.carterafinanzas.backend.Resource.ResultadoComitente.ResultadoComitenteResource;
import upc.edu.pe.carterafinanzas.backend.Resource.Valor.ValorResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Emisor;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.ResultadoComitente;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Valor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
public class ComitenteResource {

    private Long id;


    private Date Fecha;


    private Double cargo;


    private Double abono;


    private EmisorResource emisor;

    private ValorResource valor;


    private ResultadoComitenteResource resultadoComitente;



}
