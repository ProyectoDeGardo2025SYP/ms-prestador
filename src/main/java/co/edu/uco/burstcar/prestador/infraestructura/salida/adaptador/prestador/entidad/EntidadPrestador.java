package co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.prestador.entidad;

import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.EntidadIdentificador;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.calificacion.entidad.EntidadCalificacion;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.identificacionprestador.entidad.EntidadIdentificacionPrestador;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.ubicacionprestador.entidad.EntidadUbicacionPrestador;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "prestador", schema = "prestador")
public class EntidadPrestador extends EntidadIdentificador {

    @Column(length = 12)
    private String numeroIdentificacion;
    @Column(length = 30)
    private String nombre;
    @Column(length = 15, nullable = false, unique = true)
    private String usuario;
    @Column(length = 16, nullable = false)
    private String contrasena;
    @Column
    private Long numeroTelefonico;
    @ManyToOne
    @JoinColumn(name = "ubicacion_id", referencedColumnName = "identificador")
    private EntidadUbicacionPrestador entidadUbicacionPrestador;
    @ManyToOne
    @JoinColumn(name = "identificacion_id", referencedColumnName = "identificador")
    private EntidadIdentificacionPrestador entidadIdentificacionPrestador;
    @OneToMany
    @JoinTable(
            name = "prestador_calificacion",
            joinColumns = @JoinColumn(name = "prestador_id"),
            inverseJoinColumns = @JoinColumn(name = "calificacion_id"))
    private List<EntidadCalificacion> entidadCalificaciones = new ArrayList<>();

    public EntidadPrestador() {
    }

    public EntidadPrestador(String numeroIdentificacion, String nombre, String usuario, String contrasena, Long numeroTelefonico, EntidadUbicacionPrestador entidadUbicacionPrestador, EntidadIdentificacionPrestador entidadIdentificacionPrestador, ArrayList<EntidadCalificacion> entidadCalificaciones) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.numeroTelefonico = numeroTelefonico;
        this.entidadUbicacionPrestador = entidadUbicacionPrestador;
        this.entidadIdentificacionPrestador = entidadIdentificacionPrestador;
        this.entidadCalificaciones = entidadCalificaciones;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setNumeroTelefonico(Long numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public void setEntidadUbicacionPrestador(EntidadUbicacionPrestador entidadUbicacionPrestador) {
        this.entidadUbicacionPrestador = entidadUbicacionPrestador;
    }

    public void setEntidadIdentificacionPrestador(EntidadIdentificacionPrestador entidadIdentificacionPrestador) {
        this.entidadIdentificacionPrestador = entidadIdentificacionPrestador;
    }

    public void setEntidadCalificaciones(ArrayList<EntidadCalificacion> entidadCalificaciones) {
        this.entidadCalificaciones = entidadCalificaciones;
    }
}
