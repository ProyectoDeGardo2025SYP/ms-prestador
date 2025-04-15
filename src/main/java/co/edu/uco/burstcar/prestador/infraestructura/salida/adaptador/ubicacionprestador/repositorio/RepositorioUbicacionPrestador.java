package co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.ubicacionprestador.repositorio;

import co.edu.uco.burstcar.prestador.dominio.modelo.DelimitacionPrestador;
import co.edu.uco.burstcar.prestador.dominio.modelo.UbicacionPrestador;
import co.edu.uco.burstcar.prestador.dominio.modelo.ViaPrestador;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.delimitacionprestador.entidad.EntidadDelimitacionPrestador;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.delimitacionprestador.repositorio.jpa.RepositorioDelimitacionPrestadorJpa;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.ubicacionprestador.entidad.EntidadUbicacionPrestador;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.ubicacionprestador.repositorio.jpa.RepositorioUbicacionPrestadorJpa;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.viaprestador.entidad.EntidadViaPrestador;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.viaprestador.repositorio.jpa.RepositorioViaPrestadorJpa;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class RepositorioUbicacionPrestador implements co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioUbicacionPrestador {

    private final RepositorioUbicacionPrestadorJpa repositorioUbicacionPrestadorJpa;
    private final RepositorioDelimitacionPrestadorJpa repositorioDelimitacionPrestadorJpa;
    private final RepositorioViaPrestadorJpa repositorioViaPrestadorJpa;

    public RepositorioUbicacionPrestador(RepositorioUbicacionPrestadorJpa repositorioUbicacionPrestadorJpa, RepositorioDelimitacionPrestadorJpa repositorioDelimitacionPrestadorJpa, RepositorioViaPrestadorJpa repositorioViaPrestadorJpa) {
        this.repositorioUbicacionPrestadorJpa = repositorioUbicacionPrestadorJpa;
        this.repositorioDelimitacionPrestadorJpa = repositorioDelimitacionPrestadorJpa;
        this.repositorioViaPrestadorJpa = repositorioViaPrestadorJpa;
    }

    @Override
    public void registrarInformacionActualUbicacion(UbicacionPrestador ubicacionPrestador) {
        EntidadDelimitacionPrestador entidadDelimitacionPrestador = this.repositorioDelimitacionPrestadorJpa.findDelimitacion(
                ubicacionPrestador.getDelimitacionPrestador().getNombrePais(),
                ubicacionPrestador.getDelimitacionPrestador().getNombreDepartamento(),
                ubicacionPrestador.getDelimitacionPrestador().getNombreCiudad(),
                ubicacionPrestador.getDelimitacionPrestador().getNombreCorregimiento()
        );

        EntidadViaPrestador entidadViaPrestador = this.repositorioViaPrestadorJpa.findByNombre(
                ubicacionPrestador.getViaPrestador().getNombre()
        );



        EntidadUbicacionPrestador entidadUbicacionPrestador = new EntidadUbicacionPrestador(
                ubicacionPrestador.getNumeroVia(), ubicacionPrestador.getDireccion(), ubicacionPrestador.getLatitud(),
                ubicacionPrestador.getLongitud(), ubicacionPrestador.getDetalleAdicional(),
                entidadDelimitacionPrestador,
                entidadViaPrestador
        );
        entidadUbicacionPrestador.setIdentificador(ubicacionPrestador.getIdentificador());

        this.repositorioUbicacionPrestadorJpa.save(entidadUbicacionPrestador);
    }

    @Override
    public void actualizarInformacionActualUbicacion(UbicacionPrestador ubicacionPrestador) {
    }



    @Override
    public UbicacionPrestador consultarUbicacion(UUID identificador) {

        EntidadUbicacionPrestador entidadUbicacionPrestador = this.repositorioUbicacionPrestadorJpa.findById(identificador).orElse(null);

        if (entidadUbicacionPrestador == null){
            return null;
        }

        DelimitacionPrestador delimitacionPrestador = DelimitacionPrestador.nuevaDelimitacionConIdentificador(
                entidadUbicacionPrestador.getEntidadDelimitacionPrestador().getIdentificador(),
                entidadUbicacionPrestador.getEntidadDelimitacionPrestador().getNombreCorregimiento(),
                entidadUbicacionPrestador.getEntidadDelimitacionPrestador().getNombreCiudad(),
                entidadUbicacionPrestador.getEntidadDelimitacionPrestador().getIdentificacionCiudad(),
                entidadUbicacionPrestador.getEntidadDelimitacionPrestador().getNombreDepartamento(),
                entidadUbicacionPrestador.getEntidadDelimitacionPrestador().getIdentificacionDepartamento(),
                entidadUbicacionPrestador.getEntidadDelimitacionPrestador().getIdentificacionPais(),
                entidadUbicacionPrestador.getEntidadDelimitacionPrestador().getNombrePais()
        );
        ViaPrestador viaPrestador = ViaPrestador.nuevaViaConIdentificador(
                entidadUbicacionPrestador.getEntidadViaPrestador().getIdentificador(),
                entidadUbicacionPrestador.getEntidadViaPrestador().getNombre());


        return UbicacionPrestador.nuevaUbicacionConIdentificador(
                entidadUbicacionPrestador.getIdentificador(),
                entidadUbicacionPrestador.getNumeroVia(), entidadUbicacionPrestador.getDireccion(),
                entidadUbicacionPrestador.getLatitud(), entidadUbicacionPrestador.getLongitud(),
                entidadUbicacionPrestador.getDetalleAdicional(), delimitacionPrestador,
                viaPrestador);
    }

    @Override
    public UbicacionPrestador consultarUbicacionPorLatitudYLongitud(Double latiud, Double longitud) {

        EntidadUbicacionPrestador entidadUbicacionPrestador = this.repositorioUbicacionPrestadorJpa.findByLatitudAndLongitud(
                latiud, longitud);

        if (entidadUbicacionPrestador == null){
            return null;
        }

        DelimitacionPrestador delimitacionPrestador = DelimitacionPrestador.nuevaDelimitacionConIdentificador(
                entidadUbicacionPrestador.getEntidadDelimitacionPrestador().getIdentificador(),
                entidadUbicacionPrestador.getEntidadDelimitacionPrestador().getNombreCorregimiento(),
                entidadUbicacionPrestador.getEntidadDelimitacionPrestador().getNombreCiudad(),
                entidadUbicacionPrestador.getEntidadDelimitacionPrestador().getIdentificacionCiudad(),
                entidadUbicacionPrestador.getEntidadDelimitacionPrestador().getNombreDepartamento(),
                entidadUbicacionPrestador.getEntidadDelimitacionPrestador().getIdentificacionDepartamento(),
                entidadUbicacionPrestador.getEntidadDelimitacionPrestador().getIdentificacionPais(),
                entidadUbicacionPrestador.getEntidadDelimitacionPrestador().getNombrePais()
        );
        ViaPrestador viaPrestador = ViaPrestador.nuevaViaConIdentificador(
                entidadUbicacionPrestador.getEntidadViaPrestador().getIdentificador(),
                entidadUbicacionPrestador.getEntidadViaPrestador().getNombre());


        return UbicacionPrestador.nuevaUbicacionConIdentificador(entidadUbicacionPrestador.getIdentificador(),
                entidadUbicacionPrestador.getNumeroVia(), entidadUbicacionPrestador.getDireccion(),
                entidadUbicacionPrestador.getLatitud(), entidadUbicacionPrestador.getLongitud(),
                entidadUbicacionPrestador.getDetalleAdicional(), delimitacionPrestador,
                viaPrestador);
    }
}
