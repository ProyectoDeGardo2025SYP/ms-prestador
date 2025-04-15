package co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.calificacion.repositorio.jpa;

import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.calificacion.entidad.EntidadCalificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface RepositorioCalificacionJpa extends JpaRepository<EntidadCalificacion, UUID> {

    @Modifying
    @Transactional
    @Query(value = "Insert into prestador.prestador_calificacion " +
            "(prestador_id, calificacion_id) VALUES" +
            "(:prestador, :calificacion)", nativeQuery = true)
    void asociarPrestadorYCalificacion(@Param("prestador")UUID prestador,
                                       @Param("calificacion")UUID calificacion);

    @Query(value = """
    SELECT c.* 
    FROM prestador.prestador_calificacion pc
    JOIN prestador.calificacion c ON pc.calificacion_id = c.identificador
    WHERE pc.prestador_id = :prestadorId
    """, nativeQuery = true)
    List<EntidadCalificacion> obtenerCalificacionesPorPrestador(@Param("prestadorId") UUID prestadorId);
}
