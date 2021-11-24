package upc.edu.pe.carterafinanzas.backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.ResultadoComitente;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.TipoMoneda;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Usuario;

import java.util.List;

public interface TipoMonedaRepository extends JpaRepository<TipoMoneda,Long> {

    @Query("from TipoMoneda tm where tm.NombreMoneda like %:nombre%")
    List<TipoMoneda> buscarTipoMoneda(@Param("nombre") String nombre);
}
