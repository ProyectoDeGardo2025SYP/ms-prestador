package co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.identificacionprestador.repositorio;

import co.edu.uco.burstcar.prestador.dominio.modelo.IdentificacionPrestador;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.identificacionprestador.entidad.EntidadIdentificacionPrestador;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.identificacionprestador.repositorio.jpa.RepositorioIdentificacionPrestadorJpa;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class RepositorioIdentificacionPrestador implements co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioIdentificacionPrestador {

    private final RepositorioIdentificacionPrestadorJpa repositorioIdentificacionPrestadorJpa;

    public RepositorioIdentificacionPrestador(RepositorioIdentificacionPrestadorJpa repositorioIdentificacionPrestadorJpa) {
        this.repositorioIdentificacionPrestadorJpa = repositorioIdentificacionPrestadorJpa;
    }


    @Override
    public IdentificacionPrestador asociarTipoIdentificacionPrestador(String codigo) {
        EntidadIdentificacionPrestador entidadIdentificacionPrestador =
                this.repositorioIdentificacionPrestadorJpa.findByCodigo(codigo);
        if(entidadIdentificacionPrestador == null){
            return null;
        }
        return IdentificacionPrestador.nuevaIdentificacionPrestadorConIdentificador(
                entidadIdentificacionPrestador.getIdentificador(), entidadIdentificacionPrestador.getNombre(),
                entidadIdentificacionPrestador.getIdentificacionCategoriaId());
    }
}
