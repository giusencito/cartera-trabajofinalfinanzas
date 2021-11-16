package upc.edu.pe.carterafinanzas.backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Monto_Financiar;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Movimiento;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.ResultadoMovimiento;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.TipoMoneda;

import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento,Long> {


    List<Movimiento> findBytipodemonedaId(Long tipodemonedaId);
    List<Movimiento> findByResultadoMovimientoId(Long ResultadoMovimientoId);

}
