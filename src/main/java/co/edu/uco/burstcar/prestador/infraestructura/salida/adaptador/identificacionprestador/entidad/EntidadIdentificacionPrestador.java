package co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.identificacionprestador.entidad;

import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.EntidadIdentificador;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "identificacion_prestador", schema = "prestador")
public class EntidadIdentificacionPrestador extends EntidadIdentificador {

    @Column(length = 30)
    private String nombre;

    @Column(length = 5)
    private String identificacionCategoriaId;

}
