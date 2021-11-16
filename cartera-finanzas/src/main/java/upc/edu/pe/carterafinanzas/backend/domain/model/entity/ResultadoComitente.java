package upc.edu.pe.carterafinanzas.backend.domain.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "ResultadoComitente")
public class ResultadoComitente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private double totalabono;


    private double totalcargos;

    @OneToMany(targetEntity = Comitente.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "resultadocomitenteid",referencedColumnName = "id")
    private List<Comitente> comitentes;





}
