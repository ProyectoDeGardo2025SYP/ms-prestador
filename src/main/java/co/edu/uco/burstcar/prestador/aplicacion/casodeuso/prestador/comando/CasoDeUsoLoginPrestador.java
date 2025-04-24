package co.edu.uco.burstcar.prestador.aplicacion.casodeuso.prestador.comando;

import co.edu.uco.burstcar.prestador.aplicacion.casodeuso.DtoResponse;
import co.edu.uco.burstcar.prestador.aplicacion.casodeuso.prestador.comando.dto.LoginDto;
import co.edu.uco.burstcar.prestador.dominio.modelo.Prestador;
import co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioPrestador;
import co.edu.uco.burstcar.prestador.dominio.servicio.token.ServicioDeEncriptado;
import co.edu.uco.burstcar.prestador.dominio.servicio.token.ServicioGenerarToken;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CasoDeUsoLoginPrestador {

    private final ServicioGenerarToken servicioGenerarToken;
    private final RepositorioPrestador repositorioPrestador;

    public CasoDeUsoLoginPrestador(ServicioGenerarToken servicioGenerarToken, RepositorioPrestador repositorioPrestador) {
        this.servicioGenerarToken = servicioGenerarToken;
        this.repositorioPrestador = repositorioPrestador;
    }


    public DtoResponse<String> ejecutar(LoginDto dto) {

        //String encrypted = this.servicioDeEncriptado.ejecutarEncriptacion(dto.getContrasena());
        Prestador prestador = this.repositorioPrestador.realizarInicioSesion(dto.getUsuario(), dto.getContrasena());

        if(prestador == null) {
            throw new IllegalStateException("Credenciales incorrectas");
        }

        return new DtoResponse<>(this.servicioGenerarToken.generarToken(dto.getUsuario(),
                "prestador", prestador.getNumeroIdentificacion()));
    }
}