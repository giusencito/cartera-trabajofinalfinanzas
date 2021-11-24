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
@Table(name = "Cartera")
public class Cartera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


     @NotNull
     private Double valormntotal;

    @NotNull
    private Double valormetotal;


    private Double valorgarantiatotal;

    @NotNull
    private Double Tipodecambio;

    @NotNull
    private Date Fecha;


    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "usuarioid")
    private Usuario usuario;

    @OneToMany(targetEntity = Moneda.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "carteraid",referencedColumnName = "id")
    private List<Moneda> monedas;












}
