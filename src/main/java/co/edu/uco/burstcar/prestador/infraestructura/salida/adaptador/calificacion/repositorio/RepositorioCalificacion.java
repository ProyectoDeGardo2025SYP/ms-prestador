package co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.calificacion.repositorio;

import co.edu.uco.burstcar.prestador.dominio.modelo.Calificacion;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.calificacion.entidad.EntidadCalificacion;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.calificacion.repositorio.jpa.RepositorioCalificacionJpa;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.prestador.entidad.EntidadPrestador;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.prestador.repositorio.jpa.RepositorioPrestadorJpa;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class RepositorioCalificacion implements co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioCalificacion {

    private final RepositorioCalificacionJpa repositorioCalificacionJpa;
    private final RepositorioPrestadorJpa repositorioPrestadorJpa;

    public RepositorioCalificacion(RepositorioCalificacionJpa repositorioCalificacionJpa, RepositorioPrestadorJpa repositorioPrestadorJpa) {
        this.repositorioCalificacionJpa = repositorioCalificacionJpa;
        this.repositorioPrestadorJpa = repositorioPrestadorJpa;
    }

    @Override
    public UUID registrarCalificacion(Calificacion calificacion) {
        EntidadCalificacion entidadCalificacion = new EntidadCalificacion(
                calificacion.getValor(), calificacion.getComentario());
        entidadCalificacion.setIdentificador(calificacion.getIdentificador());
        return this.repositorioCalificacionJpa.save(entidadCalificacion).getIdentificador();
    }

    @Override
    public void asociarCalificacionAPrestador(UUID calificacion, String identificion) {
        EntidadPrestador entidadPrestador = this.repositorioPrestadorJpa.consultarPrestadorPorSuIdentificacion(identificion);

        this.repositorioCalificacionJpa.asociarPrestadorYCalificacion(
                entidadPrestador.getIdentificador(),
                calificacion);
    }
}
