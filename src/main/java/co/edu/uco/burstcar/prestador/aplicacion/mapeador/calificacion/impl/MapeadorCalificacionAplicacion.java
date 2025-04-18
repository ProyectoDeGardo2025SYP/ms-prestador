package co.edu.uco.burstcar.prestador.aplicacion.mapeador.calificacion.impl;

import co.edu.uco.burstcar.prestador.aplicacion.casodeuso.calificacion.comando.dto.CalificacionDto;
import co.edu.uco.burstcar.prestador.aplicacion.mapeador.MapeadorAplicacion;
import co.edu.uco.burstcar.prestador.dominio.modelo.Calificacion;
import org.springframework.stereotype.Component;

@Component
public class MapeadorCalificacionAplicacion implements MapeadorAplicacion<CalificacionDto, Calificacion> {

    @Override
    public Calificacion aDominio(CalificacionDto dto) {
        return Calificacion.nuevaCalificaion(dto.getValor(), dto.getComentario());
    }
}
