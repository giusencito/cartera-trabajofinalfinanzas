package upc.edu.pe.carterafinanzas.backend.domain.model.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "Monto_Financiar")
public class Monto_Financiar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    private double resultado;

    @NotNull
    private double tasa;

    @NotNull
    private double comision;

    @NotNull
    private double monto_desenvolsar;


    @NotNull
    private int tiempo;


    @ManyToOne(targetEntity = Descuento.class)
    @JoinColumn(name = "descuentoid")
    private Descuento descuento;



}
