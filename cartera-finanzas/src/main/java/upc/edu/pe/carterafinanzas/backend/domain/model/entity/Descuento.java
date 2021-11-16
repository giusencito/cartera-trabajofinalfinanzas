package upc.edu.pe.carterafinanzas.backend.domain.model.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "Descuento")
public class Descuento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Date Fecha;

    @NotNull
    private Date vencimiento;

    @NotNull
    private Double valorMN;

    @NotNull
    private Double valorME;



    private double montofinanciar;

    @ManyToOne(targetEntity = Valor.class)
    @JoinColumn(name = "valorid")
    private Valor valor;

    @ManyToOne(targetEntity = TipoMoneda.class)
    @JoinColumn(name = "tipomonedaid")
    private TipoMoneda tipoMoneda;

    @ManyToOne(targetEntity = Emisor.class)
    @JoinColumn(name = "emisorid")
    private Emisor emisor;


    @OneToMany(targetEntity = Monto_Financiar.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "descuentoid",referencedColumnName = "id")
    private List<Monto_Financiar> monto_financiars;


}
