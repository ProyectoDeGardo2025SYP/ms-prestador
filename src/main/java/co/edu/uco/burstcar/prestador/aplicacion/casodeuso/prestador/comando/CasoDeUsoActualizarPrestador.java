package co.edu.uco.burstcar.prestador.aplicacion.casodeuso.prestador.comando;

import co.edu.uco.burstcar.prestador.dominio.dto.PrestadorActualizacionDto;
import co.edu.uco.burstcar.prestador.dominio.servicio.prestador.ServicioActualizarPrestador;
import org.springframework.stereotype.Component;

@Component
public class CasoDeUsoActualizarPrestador {
    private final ServicioActualizarPrestador servicioActualizarPrestador;

    public CasoDeUsoActualizarPrestador(ServicioActualizarPrestador servicioActualizarPrestador) {
        this.servicioActualizarPrestador = servicioActualizarPrestador;
    }


    public void ejecutarActualizacion(PrestadorActualizacionDto dto, String numeroIdentificacion) {
        this.servicioActualizarPrestador.ejecutarActualizacion(dto, numeroIdentificacion);
    }
}