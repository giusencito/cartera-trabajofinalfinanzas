package upc.edu.pe.carterafinanzas.backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Descuento;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Moneda;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Monto_Financiar;

import java.util.List;

public interface Monto_FinanciarRepository extends JpaRepository<Monto_Financiar,Long> {


    List<Monto_Financiar> findBydescuentoID(Long DescuentoId);
}
