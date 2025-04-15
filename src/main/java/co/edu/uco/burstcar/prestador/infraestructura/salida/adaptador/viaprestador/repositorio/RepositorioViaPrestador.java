package co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.viaprestador.repositorio;

import co.edu.uco.burstcar.prestador.dominio.modelo.ViaPrestador;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.viaprestador.entidad.EntidadViaPrestador;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.viaprestador.repositorio.jpa.RepositorioViaPrestadorJpa;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioViaPrestador implements co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioViaPrestador {

    private final RepositorioViaPrestadorJpa repositorioViaPrestadorJpa;

    public RepositorioViaPrestador(RepositorioViaPrestadorJpa repositorioViaPrestadorJpa) {
        this.repositorioViaPrestadorJpa = repositorioViaPrestadorJpa;
    }

    @Override
    public ViaPrestador asociarViaUbicacion(String nombre) {
        EntidadViaPrestador entidadViaPrestador = this.repositorioViaPrestadorJpa.findByNombre(nombre);

        if(entidadViaPrestador ==null){
            return null;
        }

        return ViaPrestador.nuevaViaConIdentificador(entidadViaPrestador.getIdentificador(), entidadViaPrestador.getNombre());
    }
}
