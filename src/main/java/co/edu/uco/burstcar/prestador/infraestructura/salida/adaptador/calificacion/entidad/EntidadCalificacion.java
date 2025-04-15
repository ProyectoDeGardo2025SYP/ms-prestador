package co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.calificacion.entidad;

import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.EntidadIdentificador;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "calificacion", schema = "prestador")
public class EntidadCalificacion extends EntidadIdentificador {

    @Column
    private Double valor;

    @Column(length = 100)
    private String comentario;

    public EntidadCalificacion() {
    }

    public EntidadCalificacion(Double valor, String comentario) {
        this.valor = valor;
        this.comentario = comentario;
    }

    public Double getValor() {
        return valor;
    }

    public String getComentario() {
        return comentario;
    }
}
