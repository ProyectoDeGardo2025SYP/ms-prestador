package co.edu.uco.burstcar.prestador.dominio.servicio.ubicacionprestador;

import co.edu.uco.burstcar.prestador.dominio.modelo.UbicacionPrestador;
import co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioUbicacionPrestador;

public class ServicioRegistrarUbicacionPrestador {
    private final RepositorioUbicacionPrestador repositorioUbicacionPrestador;

    public ServicioRegistrarUbicacionPrestador(RepositorioUbicacionPrestador repositorioUbicacionPrestador) {
        this.repositorioUbicacionPrestador = repositorioUbicacionPrestador;
    }


    public void ejecutarRegistro(UbicacionPrestador ubicacionPrestador){
        this.repositorioUbicacionPrestador.registrarInformacionActualUbicacion(ubicacionPrestador);
    }
}
