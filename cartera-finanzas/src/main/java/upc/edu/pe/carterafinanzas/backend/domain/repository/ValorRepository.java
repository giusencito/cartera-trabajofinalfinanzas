package upc.edu.pe.carterafinanzas.backend.domain.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Valor;
import org.springframework.stereotype.Repository;

@Repository
public interface ValorRepository extends JpaRepository<Valor,Long> {
    @Query("from Valor j where j.ValorNombre like %:valor%")
    List<Valor> buscarValor(@Param("valor") String valor);
}
