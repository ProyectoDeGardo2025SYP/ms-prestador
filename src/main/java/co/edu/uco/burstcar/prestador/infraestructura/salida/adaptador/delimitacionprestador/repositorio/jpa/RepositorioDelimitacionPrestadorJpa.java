package co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.delimitacionprestador.repositorio.jpa;

import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.delimitacionprestador.entidad.EntidadDelimitacionPrestador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RepositorioDelimitacionPrestadorJpa extends JpaRepository<EntidadDelimitacionPrestador, UUID> {

    @Query(value = "SELECT dp.identificador, dp.nombre_corregimiento, " +
            "dp.nombre_ciudad, " +
            "dp.identificacion_ciudad, " +
            "dp.nombre_departamento, " +
            "dp.identificacion_departamento, " +
            "dp.identificacion_pais, " +
            "dp.nombre_pais " +
            "FROM prestador.delimitacion_prestador dp WHERE " +
            "nombre_pais = :pais AND nombre_departamento = :departamento AND " +
            "nombre_ciudad = :ciudad AND nombre_corregimiento = :corregimiento", nativeQuery = true)
    EntidadDelimitacionPrestador findDelimitacion(@Param("pais") String pais,
                                                        @Param("departamento") String departamento,
                                                        @Param("ciudad") String ciudad,
                                                        @Param("corregimiento") String corregimiento);
}
