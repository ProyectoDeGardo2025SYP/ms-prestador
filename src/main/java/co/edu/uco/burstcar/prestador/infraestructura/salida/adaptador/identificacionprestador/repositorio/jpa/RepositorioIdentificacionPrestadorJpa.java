package co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.identificacionprestador.repositorio.jpa;

import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.identificacionprestador.entidad.EntidadIdentificacionPrestador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositorioIdentificacionPrestadorJpa extends JpaRepository<EntidadIdentificacionPrestador, UUID> {

    @Query(value = "Select * From prestador.identificacion_prestador WHERE identificacion_categoria_id = :codigo",
            nativeQuery = true)
    EntidadIdentificacionPrestador findByCodigo(@Param("codigo") String codigo);
}
