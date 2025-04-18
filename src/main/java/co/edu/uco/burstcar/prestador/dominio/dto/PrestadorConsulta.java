package co.edu.uco.burstcar.prestador.dominio.dto;

import co.edu.uco.burstcar.prestador.dominio.modelo.Calificacion;
import co.edu.uco.burstcar.prestador.dominio.modelo.UbicacionPrestador;

import java.util.ArrayList;
import java.util.UUID;

public class PrestadorConsulta {

    private UUID identificador;
    private String numeroIdentificacion;
    private String nombre;
    private Long numeroTelefonico;
    private UbicacionPrestador ubicacionPrestador;
    private String categoriaIdentificacion;
    private ArrayList<Calificacion> calificaciones;


    private PrestadorConsulta(UUID identificador, String numeroIdentificacion, String nombre, Long numeroTelefonico, UbicacionPrestador ubicacionPrestador, String categoriaIdentificacion, ArrayList<Calificacion> calificaciones) {
        this.identificador = identificador;
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre = nombre;
        this.numeroTelefonico = numeroTelefonico;
        this.ubicacionPrestador = ubicacionPrestador;
        this.categoriaIdentificacion = categoriaIdentificacion;
        this.calificaciones = calificaciones;
    }

    public PrestadorConsulta() {
    }

    public static PrestadorConsulta consulta(UUID identificador, String numeroIdentificacion, String nombre, Long numeroTelefonico, UbicacionPrestador ubicacionPrestador, String categoriaIdentificacion, ArrayList<Calificacion> calificaciones) {
        return new PrestadorConsulta(identificador, numeroIdentificacion, nombre, numeroTelefonico, ubicacionPrestador,
                categoriaIdentificacion, calificaciones);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(Long numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public UbicacionPrestador getUbicacionPrestador() {
        return ubicacionPrestador;
    }

    public void setUbicacionPrestador(UbicacionPrestador ubicacionPrestador) {
        this.ubicacionPrestador = ubicacionPrestador;
    }

    public String getCategoriaIdentificacion() {
        return categoriaIdentificacion;
    }

    public void setCategoriaIdentificacion(String categoriaIdentificacion) {
        this.categoriaIdentificacion = categoriaIdentificacion;
    }

    public ArrayList<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(ArrayList<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }
}
