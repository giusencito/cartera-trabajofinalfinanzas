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
@Table(name = "ResultadoMovimiento")
public class ResultadoMovimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private double totalcargo;


    private double totalbono;

    @NotNull
    private double totalsaldo;


    @OneToMany(targetEntity = Movimiento.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "resultadomovimientoid",referencedColumnName = "id")
    private List<Movimiento> movimientoList;






}
