package upc.edu.pe.carterafinanzas.backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Cartera;
import java.util.List;
public interface CarteraRepository extends JpaRepository<Cartera,Long> {

    @Query("from Cartera c where c.usuario.id =:id")
    List<Cartera> findByUsuarioId(@Param("id") Long id);

}
