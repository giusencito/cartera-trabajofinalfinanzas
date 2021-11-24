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

    @Query("from Usuario u where u.Email =:correo and u.Password =:password")
    List<Usuario> inicioSesionUsuario(@Param("correo") String correo, @Param("password") String password);

    @Query("select Count(u.Email) from Usuario u where u.Email =:correo")
    int UsuarioExiste(@Param("correo") String correo);

    @Query("from Usuario u where u.Email =:correo")
    List<Usuario> CuentaUsuario(@Param("correo") String correo);

}
