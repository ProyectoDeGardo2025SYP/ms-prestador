package co.edu.uco.burstcar.prestador.aplicacion.casodeuso.calificacion.comando.dto;

import co.edu.uco.burstcar.prestador.dominio.modelo.Calificacion;
import co.edu.uco.burstcar.prestador.dominio.modelo.EntidadIdentificador;
import co.edu.uco.burstcar.prestador.dominio.modelo.IdentificacionPrestador;
import co.edu.uco.burstcar.prestador.dominio.modelo.UbicacionPrestador;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CalificacionDto extends EntidadIdentificador {

    private Double valor;

    @Size(max = 100)
    private String comentario;
}
