package co.edu.uco.burstcar.prestador.aplicacion.casodeuso.prestador.comando.dto;

import co.edu.uco.burstcar.prestador.dominio.modelo.EntidadIdentificador;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrestadorDto extends EntidadIdentificador {

    private String numeroIdentificacion;
    private String nombre;
    private String usuario;
    private String contrasena;
    private Long numeroTelefonico;
    private Double latitudPrestador;
    private Double longitudPrestador;
    private String categoriaIdentificador;
}
