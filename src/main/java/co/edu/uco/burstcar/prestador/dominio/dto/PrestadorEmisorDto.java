package co.edu.uco.burstcar.prestador.dominio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PrestadorEmisorDto implements Serializable {
    private String numeroIdentificacion;
    private String nombre;
    private String usuario;
    private Long numeroTelefonico;
    private UUID ubicacionIdentificador;
    private Double latitud;
    private Double longitud;
    private String nombreIdentificaion;
    private String identificacionCategoriaId;
    private UUID codigoIdentificador;
}
