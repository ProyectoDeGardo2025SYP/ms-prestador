package co.edu.uco.burstcar.prestador.infraestructura.config.general.rabbit;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracionPrestadorRabbit {

    private final PropiedadesConfiguracionRabbit propiedadesConfiguracionRabbit;

    public ConfiguracionPrestadorRabbit(PropiedadesConfiguracionRabbit propiedadesConfiguracionRabbit) {
        this.propiedadesConfiguracionRabbit = propiedadesConfiguracionRabbit;
    }

    @Bean
    public TopicExchange prestadorExchange() {
        return new TopicExchange(propiedadesConfiguracionRabbit.getExchange());
    }

    @Bean
    public Queue prestadorCola() {
        return new Queue(propiedadesConfiguracionRabbit.getCola(), true);
    }

    @Bean
    public Binding enlace() {
        return BindingBuilder
                .bind(prestadorCola())
                .to(prestadorExchange())
                .with(propiedadesConfiguracionRabbit.getClave());
    }

    @Bean
    public MessageConverter conversorAJson() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitClienteEnvio(ConnectionFactory conexion, MessageConverter mesanje) {
        RabbitTemplate plantilla = new RabbitTemplate(conexion);
        plantilla.setMessageConverter(mesanje);
        return plantilla;
    }
}
