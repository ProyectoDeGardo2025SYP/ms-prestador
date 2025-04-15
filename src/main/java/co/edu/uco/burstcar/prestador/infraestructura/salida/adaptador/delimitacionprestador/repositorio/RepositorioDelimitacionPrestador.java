package co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.delimitacionprestador.repositorio;

import co.edu.uco.burstcar.prestador.dominio.modelo.DelimitacionPrestador;
import co.edu.uco.burstcar.prestador.dominio.modelo.ViaPrestador;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.delimitacionprestador.entidad.EntidadDelimitacionPrestador;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.delimitacionprestador.repositorio.jpa.RepositorioDelimitacionPrestadorJpa;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class RepositorioDelimitacionPrestador implements co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioDelimitacionPrestador {

    private final RepositorioDelimitacionPrestadorJpa repositorioDelimitacionPrestadorJpa;

    public RepositorioDelimitacionPrestador(RepositorioDelimitacionPrestadorJpa repositorioDelimitacionPrestadorJpa) {
        this.repositorioDelimitacionPrestadorJpa = repositorioDelimitacionPrestadorJpa;
    }

    @Override
    public DelimitacionPrestador asociarDelimitacionUbicacion(String nombrePais, String nombreDepartamento, String nombreCiudad, String nombreCorregimiento) {
        EntidadDelimitacionPrestador entidadDelimitacionPrestador = this.repositorioDelimitacionPrestadorJpa.findDelimitacion(nombrePais, nombreDepartamento,
                nombreCiudad, nombreCorregimiento);


        if(entidadDelimitacionPrestador ==null){
            return null;
        }
        return DelimitacionPrestador.nuevaDelimitacionConIdentificador(
                entidadDelimitacionPrestador.getIdentificador(), entidadDelimitacionPrestador.getNombreCorregimiento(),
                entidadDelimitacionPrestador.getNombreCiudad(), entidadDelimitacionPrestador.getIdentificacionCiudad(),
                entidadDelimitacionPrestador.getNombreDepartamento(), entidadDelimitacionPrestador.getIdentificacionDepartamento(),
                entidadDelimitacionPrestador.getIdentificacionPais(), entidadDelimitacionPrestador.getNombrePais());
    }
}
