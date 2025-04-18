package co.edu.uco.burstcar.prestador.dominio.servicio.prestador;

import co.edu.uco.burstcar.prestador.dominio.dto.PrestadorConsulta;
import co.edu.uco.burstcar.prestador.dominio.modelo.Prestador;
import co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioPrestador;

public class ServicioConsultarPrestador {
    private final RepositorioPrestador repositorioPrestador;

    public ServicioConsultarPrestador(RepositorioPrestador repositorioPrestador) {
        this.repositorioPrestador = repositorioPrestador;
    }

    public PrestadorConsulta ejecutarConsulta(String numeroIdentificacion){
        return this.repositorioPrestador.consultarInformacionPrestador(numeroIdentificacion);
    }
}
