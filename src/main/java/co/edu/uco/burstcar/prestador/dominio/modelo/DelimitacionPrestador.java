package co.edu.uco.burstcar.prestador.dominio.modelo;

import co.edu.uco.burstcar.prestador.dominio.validador.ValidadorDeAtibutos;
import jakarta.validation.constraints.Size;
import java.util.UUID;


public class DelimitacionPrestador extends EntidadIdentificador{

    private String nombreCorregimiento;
    private String nombreCiudad;
    private UUID identificacionCiudad;
    private String nombreDepartamento;
    private UUID identificacionDepartamento;
    private UUID identificacionPais;
    private String nombrePais;

    public DelimitacionPrestador(String nombreCorregimiento, String nombreCiudad, UUID identificacionCiudad, String nombreDepartamento, UUID identificacionDepartamento, UUID identificacionPais, String nombrePais) {
        this.nombreCorregimiento = nombreCorregimiento;
        this.nombreCiudad = nombreCiudad;
        this.identificacionCiudad = identificacionCiudad;
        this.nombreDepartamento = nombreDepartamento;
        this.identificacionDepartamento = identificacionDepartamento;
        this.identificacionPais = identificacionPais;
        this.nombrePais = nombrePais;
    }

    public static DelimitacionPrestador nuevaDelimitacion(String nombreCorregimiento, String nombreCiudad, UUID identificacionCiudad, String nombreDepartamento, UUID identificacionDepartamento, UUID identificacionPais, String nombrePais) {
        ValidadorDeAtibutos.validarAtributosTexto(nombreCorregimiento, "nombre de corregimiento", 20);
        ValidadorDeAtibutos.validarAtributosTexto(nombreCiudad, "nombre de ciudad", 10);
        ValidadorDeAtibutos.validarAtributosTexto(nombreDepartamento, "nombre de departamento", 20);
        ValidadorDeAtibutos.validarAtributosTexto(nombrePais, "nombre de país", 20);
        return new DelimitacionPrestador(nombreCorregimiento, nombreCiudad, identificacionCiudad, nombreDepartamento, identificacionDepartamento, identificacionPais, nombrePais);
    }

    private DelimitacionPrestador(UUID identificador, String nombreCorregimiento, String nombreCiudad, UUID identificacionCiudad, String nombreDepartamento, UUID identificacionDepartamento, UUID identificacionPais, String nombrePais) {
        super(identificador);
        this.nombreCorregimiento = nombreCorregimiento;
        this.nombreCiudad = nombreCiudad;
        this.identificacionCiudad = identificacionCiudad;
        this.nombreDepartamento = nombreDepartamento;
        this.identificacionDepartamento = identificacionDepartamento;
        this.identificacionPais = identificacionPais;
        this.nombrePais = nombrePais;
    }

    public static DelimitacionPrestador nuevaDelimitacionConIdentificador(UUID id, String nombreCorregimiento, String nombreCiudad, UUID identificacionCiudad, String nombreDepartamento, UUID identificacionDepartamento, UUID identificacionPais, String nombrePais) {
        ValidadorDeAtibutos.validarAtributosTexto(nombreCorregimiento, "nombre de corregimiento", 20);
        ValidadorDeAtibutos.validarAtributosTexto(nombreCiudad, "nombre de ciudad", 10);
        ValidadorDeAtibutos.validarAtributosTexto(nombreDepartamento, "nombre de departamento", 20);
        ValidadorDeAtibutos.validarAtributosTexto(nombrePais, "nombre de país", 20);
        return new DelimitacionPrestador(id, nombreCorregimiento, nombreCiudad, identificacionCiudad, nombreDepartamento, identificacionDepartamento, identificacionPais, nombrePais);
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
