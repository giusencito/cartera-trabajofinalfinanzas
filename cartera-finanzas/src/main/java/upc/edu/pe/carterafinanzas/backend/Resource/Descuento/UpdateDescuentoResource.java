package upc.edu.pe.carterafinanzas.backend.Resource.Descuento;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class UpdateDescuentoResource {

    private Long id;


    private Date Fecha;


    private Date vencimiento;


    private Double valorMN;


    private Double valorME;



    private double montofinanciar;








}
