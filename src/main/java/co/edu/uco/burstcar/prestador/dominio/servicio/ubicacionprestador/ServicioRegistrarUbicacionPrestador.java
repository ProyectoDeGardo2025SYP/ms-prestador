package co.edu.uco.burstcar.prestador.dominio.servicio.ubicacionprestador;

import co.edu.uco.burstcar.prestador.dominio.modelo.UbicacionPrestador;
import co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioUbicacionPrestador;

import java.util.UUID;

public class ServicioRegistrarUbicacionPrestador {
    private final RepositorioUbicacionPrestador repositorioUbicacionPrestador;

    public ServicioRegistrarUbicacionPrestador(RepositorioUbicacionPrestador repositorioUbicacionPrestador) {
        this.repositorioUbicacionPrestador = repositorioUbicacionPrestador;
    }


    public UUID ejecutarRegistro(UbicacionPrestador ubicacionPrestador){
        return this.repositorioUbicacionPrestador.registrarInformacionActualUbicacion(ubicacionPrestador);
    }
}
