package co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.prestador.repositorio.jpa;

import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.prestador.entidad.EntidadPrestador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositorioPrestadorJpa extends JpaRepository<EntidadPrestador, UUID> {

    @Query(value = "Select * From prestador.prestador WHERE " +
            "numero_identificacion = :identificacion", nativeQuery = true)
    EntidadPrestador consultarPrestadorPorSuIdentificacion(@Param("identificacion")String identificacion);

    EntidadPrestador findByUsuario(String usuario);
}
