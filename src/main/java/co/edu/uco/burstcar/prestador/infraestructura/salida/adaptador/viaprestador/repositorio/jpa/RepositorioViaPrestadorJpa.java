package co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.viaprestador.repositorio.jpa;

import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.viaprestador.entidad.EntidadViaPrestador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RepositorioViaPrestadorJpa extends JpaRepository<EntidadViaPrestador, UUID> {

    EntidadViaPrestador findByNombre(String nombre);
}
