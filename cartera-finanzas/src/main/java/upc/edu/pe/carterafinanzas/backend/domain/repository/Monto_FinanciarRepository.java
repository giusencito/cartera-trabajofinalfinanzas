package upc.edu.pe.carterafinanzas.backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Descuento;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Moneda;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Monto_Financiar;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Valor;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface Monto_FinanciarRepository extends JpaRepository<Monto_Financiar,Long> {
    @Query("from Monto_Financiar j where j.resultado =: resultado")
    public List<Monto_Financiar> buscarMonto(Double resultado);
}
