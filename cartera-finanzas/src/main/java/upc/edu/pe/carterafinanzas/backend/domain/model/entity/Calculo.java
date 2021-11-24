package upc.edu.pe.carterafinanzas.backend.domain.model.entity;

import lombok.*;

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
@Table(name = "Calculo")
public class Calculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long Capital;

    private double TasadeInteres;

    private String periodoTasa;

    private int tiempo;

    private String periodo;

    private Long interes;

    private Long monto;
}
