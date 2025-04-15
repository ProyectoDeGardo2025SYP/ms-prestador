package co.edu.uco.burstcar.prestador.aplicacion.mapeador.prestador.impl;

import co.edu.uco.burstcar.prestador.aplicacion.casodeuso.prestador.comando.dto.PrestadorDto;
import co.edu.uco.burstcar.prestador.aplicacion.mapeador.MapeadorAplicacion;
import co.edu.uco.burstcar.prestador.dominio.dto.PrestadorEmisorDto;
import co.edu.uco.burstcar.prestador.dominio.modelo.IdentificacionPrestador;
import co.edu.uco.burstcar.prestador.dominio.modelo.UbicacionPrestador;
import co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioIdentificacionPrestador;
import co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioUbicacionPrestador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MapeadorPrestadorEmisorAplicacion implements MapeadorAplicacion<PrestadorDto, PrestadorEmisorDto> {

    @Autowired
    private RepositorioIdentificacionPrestador repositorioIdentificacionPrestador;

    @Autowired
    private RepositorioUbicacionPrestador repositorioUbicacionPrestador;

    @Override
    public PrestadorEmisorDto aDominio(PrestadorDto dto) {
        IdentificacionPrestador identificacionPrestador =
                this.repositorioIdentificacionPrestador.asociarTipoIdentificacionPrestador(dto.getCategoriaIdentificador());
        UbicacionPrestador ubicacionPrestador = this.repositorioUbicacionPrestador.consultarUbicacionPorLatitudYLongitud(dto.getLatitudPrestador(), dto.getLongitudPrestador());
        return new PrestadorEmisorDto(dto.getNumeroIdentificacion(), dto.getNombre(), dto.getUsuario(), dto.getNumeroTelefonico(), ubicacionPrestador.getIdentificador(),
                ubicacionPrestador.getLatitud(), ubicacionPrestador.getLongitud(), identificacionPrestador.getNombre(), identificacionPrestador.getIdentificacionCategoriaId(),
                identificacionPrestador.getIdentificador());
    }
}
