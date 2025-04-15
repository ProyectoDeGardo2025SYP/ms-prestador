package co.edu.uco.burstcar.prestador.aplicacion.casodeuso.calificacion.comando;

import co.edu.uco.burstcar.prestador.aplicacion.casodeuso.calificacion.comando.dto.CalificacionDto;
import co.edu.uco.burstcar.prestador.aplicacion.mapeador.calificacion.impl.MapeadorCalificacionAplicacion;
import co.edu.uco.burstcar.prestador.dominio.servicio.calificacion.ServicioRegistrarCalificacion;
import org.springframework.stereotype.Component;

@Component
public class CasoDeUsoRegistrarCalificacion {
    private final ServicioRegistrarCalificacion servicioRegistrarCalificacion;
    private final MapeadorCalificacionAplicacion mapeadorCalificacionAplicacion;

    public CasoDeUsoRegistrarCalificacion(ServicioRegistrarCalificacion servicioRegistrarCalificacion, MapeadorCalificacionAplicacion mapeadorCalificacionAplicacion) {
        this.servicioRegistrarCalificacion = servicioRegistrarCalificacion;
        this.mapeadorCalificacionAplicacion = mapeadorCalificacionAplicacion;
    }

    public void ejecutarRegistro(CalificacionDto dto, String identificacionPrestador) {
        this.servicioRegistrarCalificacion.ejecutarRegistro(
                this.mapeadorCalificacionAplicacion.aDominio(dto), identificacionPrestador);
    }
}