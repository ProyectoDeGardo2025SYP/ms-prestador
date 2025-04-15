package co.edu.uco.burstcar.prestador.aplicacion.casodeuso.prestador.comando;

import co.edu.uco.burstcar.prestador.aplicacion.casodeuso.prestador.comando.dto.PrestadorDto;
import co.edu.uco.burstcar.prestador.aplicacion.mapeador.prestador.impl.MapeadorPrestadorAplicacion;
import co.edu.uco.burstcar.prestador.aplicacion.mapeador.prestador.impl.MapeadorPrestadorEmisorAplicacion;
import co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioEmisionPrestador;
import co.edu.uco.burstcar.prestador.dominio.servicio.prestador.ServicioRegistrarPrestador;
import org.springframework.stereotype.Component;

@Component
public class CasoDeUsoRegistrarPrestador {
    private final ServicioRegistrarPrestador servicioRegistrarPrestador;
    private final MapeadorPrestadorAplicacion mapeadorPrestadorAplicacion;
    private final RepositorioEmisionPrestador repositorioEmisionPrestador;
    private final MapeadorPrestadorEmisorAplicacion mapeadorPrestadorEmisorAplicacion;

    public CasoDeUsoRegistrarPrestador(ServicioRegistrarPrestador servicioRegistrarPrestador, MapeadorPrestadorAplicacion mapeadorPrestadorAplicacion, RepositorioEmisionPrestador repositorioEmisionPrestador, MapeadorPrestadorEmisorAplicacion mapeadorPrestadorEmisorAplicacion) {
        this.servicioRegistrarPrestador = servicioRegistrarPrestador;
        this.mapeadorPrestadorAplicacion = mapeadorPrestadorAplicacion;
        this.repositorioEmisionPrestador = repositorioEmisionPrestador;
        this.mapeadorPrestadorEmisorAplicacion = mapeadorPrestadorEmisorAplicacion;
    }

    public void ejecutarRegistro(PrestadorDto dto) {
        this.servicioRegistrarPrestador.ejecutarRegistro(this.mapeadorPrestadorAplicacion.aDominio(dto));
        this.repositorioEmisionPrestador.emitirInformacionPrestador(this.mapeadorPrestadorEmisorAplicacion.aDominio(dto));
    }
}