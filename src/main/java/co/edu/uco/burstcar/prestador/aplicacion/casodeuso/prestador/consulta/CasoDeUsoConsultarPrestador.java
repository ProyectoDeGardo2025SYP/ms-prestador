package co.edu.uco.burstcar.prestador.aplicacion.casodeuso.prestador.consulta;

import co.edu.uco.burstcar.prestador.aplicacion.casodeuso.prestador.comando.dto.PrestadorDto;
import co.edu.uco.burstcar.prestador.dominio.dto.PrestadorConsulta;
import co.edu.uco.burstcar.prestador.dominio.servicio.prestador.ServicioConsultarPrestador;
import org.springframework.stereotype.Component;

@Component
public class CasoDeUsoConsultarPrestador {
    private final ServicioConsultarPrestador servicioConsultarPrestador;

    public CasoDeUsoConsultarPrestador(ServicioConsultarPrestador servicioConsultarPrestador) {
        this.servicioConsultarPrestador = servicioConsultarPrestador;
    }

    public PrestadorConsulta ejecutarConsulta(String numeroIdentificacion) {
        return this.servicioConsultarPrestador.ejecutarConsulta(numeroIdentificacion);
    }
}