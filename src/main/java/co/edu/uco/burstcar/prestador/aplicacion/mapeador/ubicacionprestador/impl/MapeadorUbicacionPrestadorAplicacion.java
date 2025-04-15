package co.edu.uco.burstcar.prestador.aplicacion.mapeador.ubicacionprestador.impl;

import co.edu.uco.burstcar.prestador.aplicacion.casodeuso.ubicacionprestador.comando.dto.UbicacionPrestadorDto;
import co.edu.uco.burstcar.prestador.aplicacion.mapeador.MapeadorAplicacion;
import co.edu.uco.burstcar.prestador.dominio.modelo.UbicacionPrestador;
import co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioDelimitacionPrestador;
import co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioViaPrestador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class MapeadorUbicacionPrestadorAplicacion implements MapeadorAplicacion<UbicacionPrestadorDto, UbicacionPrestador> {

    @Autowired
    private RepositorioViaPrestador repositorioViaPrestador;
    @Autowired
    private RepositorioDelimitacionPrestador repositorioDelimitacionPrestador;

    @Override
    public UbicacionPrestador aDominio(UbicacionPrestadorDto dto) {
        return UbicacionPrestador.nuevaUbicacion(dto.getNumeroVia(), dto.getDireccion(), dto.getLatitud(), dto.getLongitud(),
                dto.getDetalleAdicional(),
                this.repositorioDelimitacionPrestador.asociarDelimitacionUbicacion(dto.getNombrePais(), dto.getNombreDepartamento(),
                        dto.getNombreCiudad(), dto.getNombreCorregimiento()),
                this.repositorioViaPrestador.asociarViaUbicacion(dto.getNombreVia()));
    }
}
