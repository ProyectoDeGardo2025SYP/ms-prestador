package co.edu.uco.burstcar.prestador.dominio.puerto;

import co.edu.uco.burstcar.prestador.dominio.modelo.IdentificacionPrestador;

public interface RepositorioIdentificacionPrestador {

    IdentificacionPrestador asociarTipoIdentificacionPrestador(String codigo);
}
