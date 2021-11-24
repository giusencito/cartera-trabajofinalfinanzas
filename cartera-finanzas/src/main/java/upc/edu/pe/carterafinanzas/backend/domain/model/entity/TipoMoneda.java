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
@Table(name = "TipoMoneda")
public class TipoMoneda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 30)
    private String NombreMoneda;

    @OneToMany(targetEntity = Movimiento.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "tipomonedaid",referencedColumnName = "id")
    private List<Movimiento> movimientoList;

    @OneToMany(targetEntity = Moneda.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "tipomonedaid",referencedColumnName = "id")
    private List<Moneda> monedas;

    @OneToMany(targetEntity = Descuento.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "tipomonedaid",referencedColumnName = "id")
    private List<Descuento> descuentos;


}
