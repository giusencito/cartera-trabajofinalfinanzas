package upc.edu.pe.carterafinanzas.backend.Resource.Usuario;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class UpdateUsuarioResource {

    private Long id;



    @Size(max = 15)
    private String Nombre;


    @Size(max = 50)
    private String Dirreccion;



    @Size(max = 10)
    private String Ciudad;




    @Size(max = 50)
    private String Email;



    @Size(max = 50)
    private String Password;














}
