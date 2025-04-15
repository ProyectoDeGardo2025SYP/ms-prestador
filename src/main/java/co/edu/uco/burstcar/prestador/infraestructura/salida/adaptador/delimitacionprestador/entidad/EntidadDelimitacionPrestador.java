package co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.delimitacionprestador.entidad;

import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.EntidadIdentificador;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "delimitacion_prestador", schema = "prestador")
public class EntidadDelimitacionPrestador extends EntidadIdentificador {

    @Column(length = 20)
    private String nombreCorregimiento;

    @Column(length = 10)
    private String nombreCiudad;

    private UUID identificacionCiudad;

    @Column(length = 20)
    private String nombreDepartamento;

    private UUID identificacionDepartamento;

    private UUID identificacionPais;

    @Column(length = 20)
    private String nombrePais;

    public EntidadDelimitacionPrestador() {
    }

    public EntidadDelimitacionPrestador(String nombreCorregimiento, String nombreCiudad, UUID identificacionCiudad, String nombreDepartamento, UUID identificacionDepartamento, UUID identificacionPais, String nombrePais) {
        this.nombreCorregimiento = nombreCorregimiento;
        this.nombreCiudad = nombreCiudad;
        this.identificacionCiudad = identificacionCiudad;
        this.nombreDepartamento = nombreDepartamento;
        this.identificacionDepartamento = identificacionDepartamento;
        this.identificacionPais = identificacionPais;
        this.nombrePais = nombrePais;
    }

    public String getNombreCorregimiento() {
        return nombreCorregimiento;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public UUID getIdentificacionCiudad() {
        return identificacionCiudad;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public UUID getIdentificacionDepartamento() {
        return identificacionDepartamento;
    }

    public UUID getIdentificacionPais() {
        return identificacionPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }
}
