package upc.edu.pe.carterafinanzas.backend.Resource.Movimiento;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Setter
@Getter
public class CreateMovimientoResource {


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





}
