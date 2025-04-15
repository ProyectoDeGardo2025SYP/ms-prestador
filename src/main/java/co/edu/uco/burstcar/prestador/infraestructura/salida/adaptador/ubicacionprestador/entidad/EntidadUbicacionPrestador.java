package co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.ubicacionprestador.entidad;

import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.EntidadIdentificador;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.delimitacionprestador.entidad.EntidadDelimitacionPrestador;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.viaprestador.entidad.EntidadViaPrestador;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Entity
@Table(name = "ubicacion_prestador", schema = "prestador")
public class EntidadUbicacionPrestador extends EntidadIdentificador {

    @Column(length = 3)
    private String numeroVia;

    @Column(length = 15)
    private String direccion;

    private Double latitud;

    private Double longitud;

    @Column(length = 100)
    private String detalleAdicional;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name= "delimitacion_id")
    private EntidadDelimitacionPrestador entidadDelimitacionPrestador;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name= "via_prestador_id")
    private EntidadViaPrestador entidadViaPrestador;

    public EntidadUbicacionPrestador(String numeroVia, String direccion, Double latitud, Double longitud, String detalleAdicional, EntidadDelimitacionPrestador entidadDelimitacionPrestador, EntidadViaPrestador entidadViaPrestador) {
        this.numeroVia = numeroVia;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.detalleAdicional = detalleAdicional;
        this.entidadDelimitacionPrestador = entidadDelimitacionPrestador;
        this.entidadViaPrestador = entidadViaPrestador;
    }

    public String getNumeroVia() {
        return numeroVia;
    }

    public void setNumeroVia(String numeroVia) {
        this.numeroVia = numeroVia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public String getDetalleAdicional() {
        return detalleAdicional;
    }

    public void setDetalleAdicional(String detalleAdicional) {
        this.detalleAdicional = detalleAdicional;
    }

    public EntidadDelimitacionPrestador getEntidadDelimitacionPrestador() {
        return entidadDelimitacionPrestador;
    }

    public void setEntidadDelimitacionPrestador(EntidadDelimitacionPrestador entidadDelimitacionPrestador) {
        this.entidadDelimitacionPrestador = entidadDelimitacionPrestador;
    }

    public EntidadViaPrestador getEntidadViaPrestador() {
        return entidadViaPrestador;
    }

    public void setEntidadViaPrestador(EntidadViaPrestador entidadViaPrestador) {
        this.entidadViaPrestador = entidadViaPrestador;
    }
}
