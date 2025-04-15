package co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.prestador.rabbit;

import co.edu.uco.burstcar.prestador.dominio.dto.PrestadorEmisorDto;
import co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioEmisionPrestador;
import co.edu.uco.burstcar.prestador.infraestructura.config.general.rabbit.PropiedadesConfiguracionRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmitirPrestadorRabbit implements RepositorioEmisionPrestador {

    private final RabbitTemplate rabbit;
    private final PropiedadesConfiguracionRabbit propiedadesConfiguracionRabbit;

    public EmitirPrestadorRabbit(RabbitTemplate rabbit, PropiedadesConfiguracionRabbit propiedadesConfiguracionRabbit) {
        this.rabbit = rabbit;
        this.propiedadesConfiguracionRabbit = propiedadesConfiguracionRabbit;
    }

    @Override
    public void emitirInformacionPrestador(PrestadorEmisorDto emisorDto) {
        this.rabbit.convertAndSend(propiedadesConfiguracionRabbit.getExchange(),
                propiedadesConfiguracionRabbit.getClave(), emisorDto);
    }
}
