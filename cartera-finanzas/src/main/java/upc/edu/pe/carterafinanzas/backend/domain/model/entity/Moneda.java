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
@Table(name = "Moneda")
public class Moneda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    private Double valorMN;

    @NotNull
    private Double valorME;



    private Double garantia;

    @ManyToOne(targetEntity = Valor.class)
    @JoinColumn(name = "valorid")
    private Valor valor;

    @ManyToOne(targetEntity = TipoMoneda.class)
    @JoinColumn(name = "tipomonedaid")
    private TipoMoneda tipoMoneda;

    @ManyToOne(targetEntity = Emisor.class)
    @JoinColumn(name = "emisorid")
    private Emisor emisor;

    @ManyToOne(targetEntity = Cartera.class)
    @JoinColumn(name = "carteraid")
    private Cartera cartera;






}
