package co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.viaprestador.entidad;

import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.EntidadIdentificador;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Entity
@Table(name = "via_prestador", schema = "prestador")
public class EntidadViaPrestador extends EntidadIdentificador {

    @Column(length = 12)
    private String nombre;

    public String getNombre() {
        return nombre;
    }
}
