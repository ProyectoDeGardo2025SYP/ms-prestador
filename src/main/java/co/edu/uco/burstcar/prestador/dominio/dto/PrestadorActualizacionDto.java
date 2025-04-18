package co.edu.uco.burstcar.prestador.dominio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrestadorActualizacionDto {
    private String nombre;
    private String usuario;
    private String contrasena;
    private Long numeroTelefonico;

    public PrestadorActualizacionDto(String nombre, String usuario, String contrasena, Long numeroTelefonico) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.numeroTelefonico = numeroTelefonico;
    }

    public PrestadorActualizacionDto() {
    }

    public static PrestadorActualizacionDto prestadorActualizacion(String nombre, String usuario, String contrasena, Long numeroTelefonico) {
        return new PrestadorActualizacionDto(nombre, usuario, contrasena, numeroTelefonico);
    }

}
