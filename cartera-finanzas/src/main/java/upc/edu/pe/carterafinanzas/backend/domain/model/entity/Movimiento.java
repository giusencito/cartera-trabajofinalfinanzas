package upc.edu.pe.carterafinanzas.backend.domain.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "Movimiento")
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Date Fecha;

    @NotNull
    private Date FechaValor;

    @NotNull
    @NotBlank
    @Size(max = 50)
    private String Descripcion;


    private Double cargo;


    private Double abono;

    private Double saldo;

    @ManyToOne(targetEntity = TipoMoneda.class)
    @JoinColumn(name = "tipomonedaid")
    private TipoMoneda tipoMoneda;

    @ManyToOne(targetEntity = ResultadoMovimiento.class)
    @JoinColumn(name = "resultadomovimientoid")
    private ResultadoMovimiento resultadoMovimiento;
}
