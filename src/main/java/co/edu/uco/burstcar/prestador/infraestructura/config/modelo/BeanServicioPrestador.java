package co.edu.uco.burstcar.prestador.infraestructura.config.modelo;

import co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioPrestador;
import co.edu.uco.burstcar.prestador.dominio.servicio.prestador.ServicioRegistrarPrestador;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioPrestador {

    @Bean
    public ServicioRegistrarPrestador servicioRegistrarPrestador(RepositorioPrestador repositorioPrestador){
        return new ServicioRegistrarPrestador(repositorioPrestador);
    }
}
