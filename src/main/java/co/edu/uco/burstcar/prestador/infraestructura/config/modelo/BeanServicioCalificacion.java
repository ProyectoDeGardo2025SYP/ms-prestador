package co.edu.uco.burstcar.prestador.infraestructura.config.modelo;

import co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioCalificacion;
import co.edu.uco.burstcar.prestador.dominio.servicio.calificacion.ServicioRegistrarCalificacion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioCalificacion {

    @Bean
    public ServicioRegistrarCalificacion servicioRegistrarCalificacion(RepositorioCalificacion repositorioCalificacion){
        return new ServicioRegistrarCalificacion(repositorioCalificacion);
    }
}
