package upc.edu.pe.carterafinanzas.backend.domain.model.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "Comitente")
public class Comitente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Date Fecha;

    @NotNull
    private double cargo;

    @NotNull
    private double abono;

    @ManyToOne(targetEntity = Emisor.class)
    @JoinColumn(name = "emisorid")
    private Emisor emisor;

    @ManyToOne(targetEntity = Valor.class)
    @JoinColumn(name = "valorid")
    private Valor valor;

    @ManyToOne(targetEntity = ResultadoComitente.class)
    @JoinColumn(name = "resultadocomitenteid")
    private ResultadoComitente resultadoComitente;

}
