package co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.ubicacionprestador.repositorio.jpa;

import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.ubicacionprestador.entidad.EntidadUbicacionPrestador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositorioUbicacionPrestadorJpa extends JpaRepository<EntidadUbicacionPrestador, UUID> {

    @Query(value = "Select * from prestador.ubicacion_prestador WHERE latitud = :latitud AND " +
            "longitud = :longitud", nativeQuery = true)
    EntidadUbicacionPrestador findByLatitudAndLongitud(@Param("latitud") Double latitud, @Param("longitud") Double longitud);
}
