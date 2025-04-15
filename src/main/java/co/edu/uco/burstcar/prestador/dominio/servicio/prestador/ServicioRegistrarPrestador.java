package co.edu.uco.burstcar.prestador.dominio.servicio.prestador;

import co.edu.uco.burstcar.prestador.dominio.modelo.Prestador;
import co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioPrestador;

public class ServicioRegistrarPrestador {
    private final RepositorioPrestador repositorioPrestador;

    public ServicioRegistrarPrestador(RepositorioPrestador repositorioPrestador) {
        this.repositorioPrestador = repositorioPrestador;
    }

    public void ejecutarRegistro(Prestador prestador){
        System.out.println("DTO en dominio" + prestador.getIdentificacionPrestador().getIdentificacionCategoriaId());
        this.repositorioPrestador.registrarInformacionPersonal(prestador);
    }
}
