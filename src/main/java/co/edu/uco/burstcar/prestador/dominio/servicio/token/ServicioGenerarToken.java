package co.edu.uco.burstcar.prestador.dominio.servicio.token;

import java.util.List;

public interface ServicioGenerarToken {

    String generarToken(String user, String rol, String id);

}
