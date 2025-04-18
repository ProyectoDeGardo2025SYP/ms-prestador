package co.edu.uco.burstcar.prestador.dominio.modelo;

import co.edu.uco.burstcar.prestador.dominio.validador.ValidadorDeAtibutos;
import java.util.UUID;


public class ViaPrestador extends EntidadIdentificador{

    private String nombre;

    private ViaPrestador(String nombre) {
        this.nombre = nombre;
    }

    public static ViaPrestador nuevaVia(String nombre) {
        ValidadorDeAtibutos.validarAtributosTexto(nombre, "nombre de la vía", 17);
        return new ViaPrestador(nombre);
    }

    private ViaPrestador(UUID identificador, String nombre) {
        super(identificador);
        this.nombre = nombre;
    }

    public static ViaPrestador nuevaViaConIdentificador(UUID id, String nombre) {
        ValidadorDeAtibutos.validarAtributosTexto(nombre, "nombre de la vía", 17);
        return new ViaPrestador(id, nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
