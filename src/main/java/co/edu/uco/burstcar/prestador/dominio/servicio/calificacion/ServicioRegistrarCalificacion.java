package co.edu.uco.burstcar.prestador.dominio.servicio.calificacion;

import co.edu.uco.burstcar.prestador.dominio.modelo.Calificacion;
import co.edu.uco.burstcar.prestador.dominio.modelo.Prestador;
import co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioCalificacion;

import java.util.UUID;

public class ServicioRegistrarCalificacion {
    private final RepositorioCalificacion repositorioCalificacion;

    public ServicioRegistrarCalificacion(RepositorioCalificacion repositorioCalificacion) {
        this.repositorioCalificacion = repositorioCalificacion;
    }

    public void ejecutarRegistro(Calificacion calificacion, String identificacionPrestador){
        UUID id = this.repositorioCalificacion.registrarCalificacion(calificacion);
        this.repositorioCalificacion.asociarCalificacionAPrestador(id,identificacionPrestador);
    }
}
