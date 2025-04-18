package co.edu.uco.burstcar.prestador.dominio.dto;

import java.io.Serializable;
import java.util.UUID;


public class PrestadorEmisorDto implements Serializable {
    private String numeroIdentificacion;
    private String nombre;
    private String usuario;
    private Long numeroTelefonico;
    private UUID ubicacionIdentificador;
    private Double latitud;
    private Double longitud;
    private String nombreIdentificaion;
    private String identificacionCategoriaId;
    private UUID codigoIdentificador;

    public PrestadorEmisorDto() {
    }

    private PrestadorEmisorDto(String numeroIdentificacion, String nombre, String usuario, Long numeroTelefonico, UUID ubicacionIdentificador, Double latitud, Double longitud, String nombreIdentificaion, String identificacionCategoriaId, UUID codigoIdentificador) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre = nombre;
        this.usuario = usuario;
        this.numeroTelefonico = numeroTelefonico;
        this.ubicacionIdentificador = ubicacionIdentificador;
        this.latitud = latitud;
        this.longitud = longitud;
        this.nombreIdentificaion = nombreIdentificaion;
        this.identificacionCategoriaId = identificacionCategoriaId;
        this.codigoIdentificador = codigoIdentificador;
    }

    public static PrestadorEmisorDto emisor(String numeroIdentificacion, String nombre, String usuario, Long numeroTelefonico, UUID ubicacionIdentificador, Double latitud, Double longitud, String nombreIdentificaion, String identificacionCategoriaId, UUID codigoIdentificador) {
        return new PrestadorEmisorDto(numeroIdentificacion, nombre, usuario, numeroTelefonico,
                ubicacionIdentificador, latitud, longitud, nombreIdentificaion, identificacionCategoriaId, codigoIdentificador);
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Long getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(Long numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public UUID getUbicacionIdentificador() {
        return ubicacionIdentificador;
    }

    public void setUbicacionIdentificador(UUID ubicacionIdentificador) {
        this.ubicacionIdentificador = ubicacionIdentificador;
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

    public String getNombreIdentificaion() {
        return nombreIdentificaion;
    }

    public void setNombreIdentificaion(String nombreIdentificaion) {
        this.nombreIdentificaion = nombreIdentificaion;
    }

    public String getIdentificacionCategoriaId() {
        return identificacionCategoriaId;
    }

    public void setIdentificacionCategoriaId(String identificacionCategoriaId) {
        this.identificacionCategoriaId = identificacionCategoriaId;
    }

    public UUID getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public void setCodigoIdentificador(UUID codigoIdentificador) {
        this.codigoIdentificador = codigoIdentificador;
    }
}
