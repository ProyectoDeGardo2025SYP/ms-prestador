package co.edu.uco.burstcar.prestador.dominio.servicio.prestador;

import co.edu.uco.burstcar.prestador.dominio.dto.PrestadorActualizacionDto;
import co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioPrestador;

public class ServicioActualizarPrestador {
    private final RepositorioPrestador repositorioPrestador;

    public ServicioActualizarPrestador(RepositorioPrestador repositorioPrestador) {
        this.repositorioPrestador = repositorioPrestador;
    }

    public void ejecutarActualizacion(PrestadorActualizacionDto dto, String numeroIdentificacion){
        this.repositorioPrestador.actaulizarInformacionDelPrestador(dto, numeroIdentificacion);
    }
}
