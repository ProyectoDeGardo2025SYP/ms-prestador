package co.edu.uco.burstcar.prestador.aplicacion.casodeuso.ubicacionprestador.comando;

import co.edu.uco.burstcar.prestador.aplicacion.casodeuso.ubicacionprestador.comando.dto.UbicacionPrestadorDto;
import co.edu.uco.burstcar.prestador.aplicacion.mapeador.ubicacionprestador.impl.MapeadorUbicacionPrestadorAplicacion;
import co.edu.uco.burstcar.prestador.dominio.modelo.ViaPrestador;
import co.edu.uco.burstcar.prestador.dominio.servicio.ubicacionprestador.ServicioRegistrarUbicacionPrestador;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CasoDeUsoRegistrarUbicacionPrestador {
    private final ServicioRegistrarUbicacionPrestador servicioRegistrarUbicacionPrestador;
    private final MapeadorUbicacionPrestadorAplicacion mapeadorUbicacionPrestadorAplicacion;
    public CasoDeUsoRegistrarUbicacionPrestador(ServicioRegistrarUbicacionPrestador servicioRegistrarUbicacionPrestador, MapeadorUbicacionPrestadorAplicacion mapeadorUbicacionPrestadorAplicacion) {
        this.servicioRegistrarUbicacionPrestador = servicioRegistrarUbicacionPrestador;
        this.mapeadorUbicacionPrestadorAplicacion = mapeadorUbicacionPrestadorAplicacion;
    }


    public UUID ejecutarRegistro(UbicacionPrestadorDto dto) {
        return this.servicioRegistrarUbicacionPrestador.ejecutarRegistro(
                this.mapeadorUbicacionPrestadorAplicacion.aDominio(dto));

    }
}