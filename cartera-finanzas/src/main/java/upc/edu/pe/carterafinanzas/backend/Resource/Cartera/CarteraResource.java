package upc.edu.pe.carterafinanzas.backend.Resource.Cartera;

import lombok.Getter;
import lombok.Setter;
import upc.edu.pe.carterafinanzas.backend.Resource.Usuario.UsuarioResource;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Usuario;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Setter
@Getter
public class CarteraResource {

    private Long id;



    private Double valormntotal;


    private Double valormetotal;


    private Double valorgarantiatotal;


    private Double Tipodecambio;


    private Date Fecha;


    private UsuarioResource usuario;







}
