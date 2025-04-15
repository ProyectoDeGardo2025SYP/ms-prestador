package co.edu.uco.burstcar.prestador;

import co.edu.uco.burstcar.prestador.infraestructura.config.general.token.PropiedadesConfiguracionJwt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties(PropiedadesConfiguracionJwt.class)
public class PrestadorApplication {

    public static void main(final String[] args) {
        SpringApplication.run(PrestadorApplication.class, args);
    }

}
