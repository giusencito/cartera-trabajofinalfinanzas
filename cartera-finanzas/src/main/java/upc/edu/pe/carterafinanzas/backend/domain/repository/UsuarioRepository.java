package upc.edu.pe.carterafinanzas.backend.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.TipoMoneda;
import upc.edu.pe.carterafinanzas.backend.domain.model.entity.Usuario;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    @Query("from Usuario u where u.Nombre like %:nombre%")
    List<Usuario> buscarUsuario(@Param("nombre") String nombre);
}
