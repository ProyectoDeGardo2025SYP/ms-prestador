package co.edu.uco.burstcar.prestador.infraestructura.config.general.token;

import co.edu.uco.burstcar.prestador.dominio.dto.PrestadorActualDto;
import co.edu.uco.burstcar.prestador.dominio.servicio.token.ServicioObtenerPrestadorActual;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class ServicioObtenerPrestadorActualJwt implements ServicioObtenerPrestadorActual {

    private String obtenerTokenActual() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getHeader(HttpHeaders.AUTHORIZATION);
    }


    @Override
    public PrestadorActualDto obtener() {
        DecodedJWT decoded = JWT.decode(obtenerTokenActual());
        return PrestadorActualDto.prestadorActual(decoded.getSubject(),
                decoded.getClaim("rol").asString());

    }
}
