package co.edu.uco.burstcar.prestador.dominio.modelo;

import co.edu.uco.burstcar.prestador.dominio.validador.ValidadorDeAtibutos;

import java.util.UUID;


public class IdentificacionPrestador extends EntidadIdentificador{

    private String nombre;
    private String identificacionCategoriaId;


    private IdentificacionPrestador(String nombre, String identificacionCategoriaId) {
        this.nombre = nombre;
        this.identificacionCategoriaId = identificacionCategoriaId;
    }

    public static IdentificacionPrestador nuevaIdentificacionPrestador(String nombre, String identificacionCategoriaId){
        ValidadorDeAtibutos.validarAtributosTexto(nombre, "nombre de la identificacion", 30);
        ValidadorDeAtibutos.validarAtributosTexto(identificacionCategoriaId, "Categoría de la identificación", 5);
        return new IdentificacionPrestador(nombre, identificacionCategoriaId);
    }

    private IdentificacionPrestador(UUID identificador, String nombre, String identificacionCategoriaId) {
        super(identificador);
        this.nombre = nombre;
        this.identificacionCategoriaId = identificacionCategoriaId;
    }

    public static IdentificacionPrestador nuevaIdentificacionPrestadorConIdentificador(UUID id, String nombre, String identificacionCategoriaId){
        ValidadorDeAtibutos.validarAtributosTexto(nombre, "nombre de la identificacion", 30);
        ValidadorDeAtibutos.validarAtributosTexto(identificacionCategoriaId, "Categoría de la identificación", 5);
        return new IdentificacionPrestador(id, nombre, identificacionCategoriaId);
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificacionCategoriaId() {
        return identificacionCategoriaId;
    }
}
