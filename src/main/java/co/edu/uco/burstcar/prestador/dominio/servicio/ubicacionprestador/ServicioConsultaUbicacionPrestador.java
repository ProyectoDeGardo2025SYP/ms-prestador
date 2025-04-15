package co.edu.uco.burstcar.prestador.dominio.servicio.ubicacionprestador;

import co.edu.uco.burstcar.prestador.dominio.modelo.UbicacionPrestador;
import co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioUbicacionPrestador;

import java.util.UUID;

public class ServicioConsultaUbicacionPrestador {
    private final RepositorioUbicacionPrestador repositorioUbicacionPrestador;

    public ServicioConsultaUbicacionPrestador(RepositorioUbicacionPrestador repositorioUbicacionPrestador) {
        this.repositorioUbicacionPrestador = repositorioUbicacionPrestador;
    }


    public UbicacionPrestador ejecutarConsulta(UUID id){
        return this.repositorioUbicacionPrestador.consultarUbicacion(id);
    }
}
