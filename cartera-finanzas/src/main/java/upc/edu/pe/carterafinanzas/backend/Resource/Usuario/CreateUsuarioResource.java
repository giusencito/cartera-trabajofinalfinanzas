package upc.edu.pe.carterafinanzas.backend.Resource.Usuario;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
public class CreateUsuarioResource {


    @NotNull
    @NotBlank
    @Size(max = 15)
    private String Nombre;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String Dirreccion;


    @NotNull
    @NotBlank
    @Size(max = 10)
    private String Ciudad;



    @NotNull
    @NotBlank
    @Size(max = 50)
    private String Email;


    @NotNull
    @NotBlank
    @Size(max = 50)
    private String Password;















}
