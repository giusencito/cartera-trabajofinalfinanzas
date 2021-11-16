package upc.edu.pe.carterafinanzas.backend.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
