package co.edu.uco.burstcar.prestador.dominio.servicio.ubicacionprestador;

import co.edu.uco.burstcar.prestador.dominio.modelo.UbicacionPrestador;
import co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioUbicacionPrestador;

public class ServicioActualizarUbicacionPrestador {
    private final RepositorioUbicacionPrestador repositorioUbicacionPrestador;

    public ServicioActualizarUbicacionPrestador(RepositorioUbicacionPrestador repositorioUbicacionPrestador) {
        this.repositorioUbicacionPrestador = repositorioUbicacionPrestador;
    }


    public void ejecutarActualizacion(UbicacionPrestador ubicacionPrestador){
        this.repositorioUbicacionPrestador.actualizarInformacionActualUbicacion(ubicacionPrestador);
    }
}
