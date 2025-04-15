package co.edu.uco.burstcar.prestador.infraestructura.config.modelo;

import co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioUbicacionPrestador;
import co.edu.uco.burstcar.prestador.dominio.servicio.ubicacionprestador.ServicioActualizarUbicacionPrestador;
import co.edu.uco.burstcar.prestador.dominio.servicio.ubicacionprestador.ServicioConsultaUbicacionPrestador;
import co.edu.uco.burstcar.prestador.dominio.servicio.ubicacionprestador.ServicioRegistrarUbicacionPrestador;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicioUbicacionPrestador {

    @Bean
    public ServicioRegistrarUbicacionPrestador servicioRegistrarUbicacionPrestador(RepositorioUbicacionPrestador repositorioUbicacionPrestador){
        return new ServicioRegistrarUbicacionPrestador(repositorioUbicacionPrestador);
    }

    @Bean
    public ServicioActualizarUbicacionPrestador servicioActualizarUbicacionPrestador(RepositorioUbicacionPrestador repositorioUbicacionPrestador){
        return new ServicioActualizarUbicacionPrestador(repositorioUbicacionPrestador);
    }

    @Bean
    public ServicioConsultaUbicacionPrestador servicioConsultaUbicacionPrestador(RepositorioUbicacionPrestador repositorioUbicacionPrestador){
        return new ServicioConsultaUbicacionPrestador(repositorioUbicacionPrestador);
    }
}
