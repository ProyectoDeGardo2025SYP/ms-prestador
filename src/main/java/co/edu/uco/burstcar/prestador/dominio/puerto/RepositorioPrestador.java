package co.edu.uco.burstcar.prestador.dominio.puerto;

import co.edu.uco.burstcar.prestador.dominio.modelo.Prestador;
import co.edu.uco.burstcar.prestador.dominio.modelo.UbicacionPrestador;

public interface RepositorioPrestador {

    void registrarInformacionPersonal(Prestador prestador);
    Prestador realizarInicioSesion(String usuario, String contrasena);
    Prestador consultarInformacionPrestador(String numeroIdentificacion);
    UbicacionPrestador realizarSeguimientoUbicacion(Prestador prestador);

    boolean validarPrestador(String numeroIdentificacion);
}
