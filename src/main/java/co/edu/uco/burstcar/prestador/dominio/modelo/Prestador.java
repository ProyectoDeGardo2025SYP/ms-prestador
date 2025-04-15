package co.edu.uco.burstcar.prestador.dominio.modelo;

import co.edu.uco.burstcar.prestador.dominio.validador.ValidadorDeAtibutos;
import co.edu.uco.burstcar.prestador.dominio.validador.ValidadorDeObjetos;
import java.util.ArrayList;
import java.util.UUID;



public class Prestador extends EntidadIdentificador{
    private String numeroIdentificacion;
    private String nombre;
    private String usuario;
    private String contrasena;
    private Long numeroTelefonico;
    private UbicacionPrestador ubicacion;
    private IdentificacionPrestador identificacionPrestador;
    private ArrayList<Calificacion> calificaciones;

    private Prestador(String numeroIdentificacion, String nombre, String usuario, String contrasena, Long numeroTelefonico, UbicacionPrestador ubicacion, IdentificacionPrestador identificacionPrestador, ArrayList<Calificacion> calificaciones) {
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.numeroTelefonico = numeroTelefonico;
        this.ubicacion = ubicacion;
        this.identificacionPrestador = identificacionPrestador;
        this.calificaciones = calificaciones;
    }

    public static Prestador nuevoPrestador(String numeroIdentificacion, String nombre, String usuario, String contrasena, Long numeroTelefonico, UbicacionPrestador ubicacion, IdentificacionPrestador identificacionPrestador, ArrayList<Calificacion> calificaciones) {
        ValidadorDeAtibutos.validarAtributosTexto(numeroIdentificacion, "Número de identificación", 12);
        ValidadorDeAtibutos.validarAtributosTexto(nombre, "nombre", 30);
        ValidadorDeAtibutos.validarAtributosTexto(usuario, "usuario", 15);
        ValidadorDeAtibutos.validarAtributosTexto(contrasena, "contraseña", 16);
        ValidadorDeObjetos.validateNoNulos(numeroTelefonico, "Número telefonico");
        ValidadorDeObjetos.validateNoNulos(ubicacion, "Ubicación del prestador");
        ValidadorDeObjetos.validateNoNulos(identificacionPrestador, "Identificación del prestador");
        return new Prestador(numeroIdentificacion, nombre, usuario, contrasena, numeroTelefonico, ubicacion, identificacionPrestador, calificaciones);
    }

    private Prestador(UUID identificador, String numeroIdentificacion, String nombre, String usuario, String contrasena, Long numeroTelefonico, UbicacionPrestador ubicacion, IdentificacionPrestador identificacionPrestador, ArrayList<Calificacion> calificaciones) {
        super(identificador);
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.numeroTelefonico = numeroTelefonico;
        this.ubicacion = ubicacion;
        this.identificacionPrestador = identificacionPrestador;
        this.calificaciones = calificaciones;
    }

    public static Prestador nuevoPrestadorConIdentificador(UUID id, String numeroIdentificacion, String nombre, String usuario, String contrasena, Long numeroTelefonico, UbicacionPrestador ubicacion, IdentificacionPrestador identificacionPrestador, ArrayList<Calificacion> calificaciones) {
        ValidadorDeAtibutos.validarAtributosTexto(numeroIdentificacion, "Número de identificación", 12);
        ValidadorDeAtibutos.validarAtributosTexto(nombre, "nombre", 30);
        ValidadorDeAtibutos.validarAtributosTexto(usuario, "usuario", 15);
        ValidadorDeAtibutos.validarAtributosTexto(contrasena, "contraseña", 16);
        ValidadorDeObjetos.validateNoNulos(numeroTelefonico, "Número telefonico");
        ValidadorDeObjetos.validateNoNulos(ubicacion, "Ubicación del prestador");
        ValidadorDeObjetos.validateNoNulos(identificacionPrestador, "Identificación del prestador");
        return new Prestador(id, numeroIdentificacion, nombre, usuario, contrasena, numeroTelefonico, ubicacion, identificacionPrestador, calificaciones);
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public Long getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public UbicacionPrestador getUbicacion() {
        return ubicacion;
    }

    public IdentificacionPrestador getIdentificacionPrestador() {
        return identificacionPrestador;
    }

    public ArrayList<Calificacion> getCalificaciones() {
        return calificaciones;
    }
}
