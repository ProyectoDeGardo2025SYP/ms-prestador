package co.edu.uco.burstcar.prestador.dominio.modelo;

import co.edu.uco.burstcar.prestador.dominio.validador.ValidadorDeAtibutos;
import co.edu.uco.burstcar.prestador.dominio.validador.ValidadorDeObjetos;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public class UbicacionPrestador extends EntidadIdentificador{

    private String numeroVia;
    private String direccion;
    private Double latitud;
    private Double longitud;
    private String detalleAdicional;
    private DelimitacionPrestador delimitacionPrestador;
    private ViaPrestador viaPrestador;

    private UbicacionPrestador(String numeroVia, String direccion, Double latitud, Double longitud, String detalleAdicional, DelimitacionPrestador delimitacionPrestador, ViaPrestador viaPrestador) {
        this.numeroVia = numeroVia;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.detalleAdicional = detalleAdicional;
        this.delimitacionPrestador = delimitacionPrestador;
        this.viaPrestador = viaPrestador;
    }

    public static UbicacionPrestador nuevaUbicacion(String numeroVia, String direccion, Double latitud, Double longitud, String detalleAdicional, DelimitacionPrestador delimitacionPrestador, ViaPrestador viaPrestador) {
        ValidadorDeAtibutos.validarAtributosTexto(numeroVia, "número de vía", 3);
        ValidadorDeAtibutos.validarAtributosTexto(direccion, "dirección", 15);
        ValidadorDeObjetos.validateNoNulos(latitud, "latitud");
        ValidadorDeObjetos.validateNoNulos(longitud, "longitud");
        ValidadorDeAtibutos.validarAtributosTexto(detalleAdicional, "detalle adicional", 100);
        ValidadorDeObjetos.validateNoNulos(delimitacionPrestador, "delimitación");
        ValidadorDeObjetos.validateNoNulos(viaPrestador, "vía");
        return new UbicacionPrestador(numeroVia, direccion, latitud, longitud, detalleAdicional, delimitacionPrestador, viaPrestador);
    }

    private UbicacionPrestador(UUID identificador, String numeroVia, String direccion, Double latitud, Double longitud, String detalleAdicional, DelimitacionPrestador delimitacionPrestador, ViaPrestador viaPrestador) {
        super(identificador);
        this.numeroVia = numeroVia;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.detalleAdicional = detalleAdicional;
        this.delimitacionPrestador = delimitacionPrestador;
        this.viaPrestador = viaPrestador;
    }

    public static UbicacionPrestador nuevaUbicacionConIdentificador(UUID id, String numeroVia, String direccion, Double latitud, Double longitud, String detalleAdicional, DelimitacionPrestador delimitacionPrestador, ViaPrestador viaPrestador) {
        ValidadorDeAtibutos.validarAtributosTexto(numeroVia, "número de vía", 3);
        ValidadorDeAtibutos.validarAtributosTexto(direccion, "dirección", 15);
        ValidadorDeObjetos.validateNoNulos(latitud, "latitud");
        ValidadorDeObjetos.validateNoNulos(longitud, "longitud");
        ValidadorDeAtibutos.validarAtributosTexto(detalleAdicional, "detalle adicional", 100);
        ValidadorDeObjetos.validateNoNulos(delimitacionPrestador, "delimitación");
        ValidadorDeObjetos.validateNoNulos(viaPrestador, "vía");
        return new UbicacionPrestador(id, numeroVia, direccion, latitud, longitud, detalleAdicional, delimitacionPrestador, viaPrestador);
    }

    public String getNumeroVia() {
        return numeroVia;
    }
    public String getDireccion() {
        return direccion;
    }
    public Double getLatitud() {
        return latitud;
    }
    public Double getLongitud() {
        return longitud;
    }
    public String getDetalleAdicional() {
        return detalleAdicional;
    }
    public DelimitacionPrestador getDelimitacionPrestador() {
        return delimitacionPrestador;
    }
    public ViaPrestador getViaPrestador() {
        return viaPrestador;
    }
}
