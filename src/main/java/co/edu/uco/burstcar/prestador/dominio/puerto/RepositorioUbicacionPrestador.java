package co.edu.uco.burstcar.prestador.dominio.puerto;

import co.edu.uco.burstcar.prestador.dominio.modelo.UbicacionPrestador;

import java.util.UUID;

public interface RepositorioUbicacionPrestador {
    void registrarInformacionActualUbicacion(UbicacionPrestador ubicacionPrestador);
    void actualizarInformacionActualUbicacion(UbicacionPrestador ubicacionPrestador);
    UbicacionPrestador consultarUbicacion(UUID identificador);
    UbicacionPrestador consultarUbicacionPorLatitudYLongitud(Double latiud, Double longitud);
}
