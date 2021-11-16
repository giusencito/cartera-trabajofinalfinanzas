package upc.edu.pe.carterafinanzas.backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.ResultadoComitente;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.TipoMoneda;

public interface TipoMonedaRepository extends JpaRepository<TipoMoneda,Long> {
}
