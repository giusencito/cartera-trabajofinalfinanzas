package upc.edu.pe.carterafinanzas.backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Cartera;
import java.util.List;
public interface CarteraRepository extends JpaRepository<Cartera,Long> {

    List<Cartera> findByUsuarioId(Long usuarioId);

}
