package co.edu.uco.burstcar.prestador.dominio.puerto;

import co.edu.uco.burstcar.prestador.dominio.modelo.Calificacion;

import java.util.UUID;

public interface RepositorioCalificacion {

    UUID registrarCalificacion(Calificacion calificacion);
    void asociarCalificacionAPrestador(UUID calificacion, String identificion);
}
