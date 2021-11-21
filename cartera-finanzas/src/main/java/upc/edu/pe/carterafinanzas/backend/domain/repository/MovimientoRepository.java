package upc.edu.pe.carterafinanzas.backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Monto_Financiar;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Movimiento;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.ResultadoMovimiento;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.TipoMoneda;

import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento,Long> {

    @Query("select count(a.id) from Movimiento a where a.id =:id")
    public int existeActividad(@Param("id") int id);

    @Query("from Movimiento a where a.tipoMoneda.NombreMoneda like %:anio%")
    List<Movimiento> buscartipomoneda(@Param("anio") String anio);

    @Query("from Movimiento a where a.resultadoMovimiento.id  =:anio")
    List<Movimiento> buscarAnio(@Param("anio") Long anio);



}
