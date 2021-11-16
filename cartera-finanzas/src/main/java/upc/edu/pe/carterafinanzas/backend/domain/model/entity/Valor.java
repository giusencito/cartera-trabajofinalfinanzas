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
@Table(name = "Valor")
public class Valor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 30)
    private String ValorNombre;


    @OneToMany(targetEntity = Comitente.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "valorid",referencedColumnName = "id")
    private List<Comitente> comitentes;

    @OneToMany(targetEntity = Moneda.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "valorid",referencedColumnName = "id")
    private List<Moneda> monedas;


    @OneToMany(targetEntity = Descuento.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "valorid",referencedColumnName = "id")
    private List<Descuento> descuentos;



}
