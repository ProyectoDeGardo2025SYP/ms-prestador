package co.edu.uco.burstcar.prestador.aplicacion.mapeador.prestador.impl;

import co.edu.uco.burstcar.prestador.aplicacion.casodeuso.prestador.comando.dto.PrestadorDto;
import co.edu.uco.burstcar.prestador.aplicacion.mapeador.MapeadorAplicacion;
import co.edu.uco.burstcar.prestador.dominio.modelo.Prestador;
import co.edu.uco.burstcar.prestador.dominio.modelo.UbicacionPrestador;
import co.edu.uco.burstcar.prestador.dominio.puerto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MapeadorPrestadorAplicacion implements MapeadorAplicacion<PrestadorDto, Prestador> {

    @Autowired
    private RepositorioIdentificacionPrestador repositorioIdentificacionPrestador;
    @Autowired
    private RepositorioUbicacionPrestador repositorioUbicacionPrestador;
    @Autowired
    private RepositorioCalificacion repositorioCalificacion;


    @Override
    public Prestador aDominio(PrestadorDto dto) {

        UbicacionPrestador ubicacionPrestador =
                this.repositorioUbicacionPrestador.consultarUbicacionPorLatitudYLongitud(dto.getLatitudPrestador(), dto.getLongitudPrestador());

        return Prestador.nuevoPrestador(dto.getNumeroIdentificacion(), dto.getNombre(), dto.getUsuario(), dto.getContrasena(),
                dto.getNumeroTelefonico(),
                ubicacionPrestador,
                this.repositorioIdentificacionPrestador.asociarTipoIdentificacionPrestador(dto.getCategoriaIdentificador()),
                new ArrayList<>());
    }
}
