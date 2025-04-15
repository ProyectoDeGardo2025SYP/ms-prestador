package co.edu.uco.burstcar.prestador.aplicacion.casodeuso.ubicacionprestador.comando.dto;

import co.edu.uco.burstcar.prestador.dominio.modelo.EntidadIdentificador;


public class UbicacionPrestadorDto extends EntidadIdentificador {
    private String numeroVia;
    private String direccion;

    private Double latitud;
    private Double longitud;
    private String detalleAdicional;

    private String nombrePais;
    private String nombreDepartamento;
    private String nombreCiudad;
    private String nombreCorregimiento;

    private String nombreVia;
    public UbicacionPrestadorDto(String numeroVia, String direccion, Double latitud, Double longitud, String detalleAdicional, String nombrePais, String nombreDepartamento, String nombreCiudad, String nombreCorregimiento, String nombreVia) {
        this.numeroVia = numeroVia;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.detalleAdicional = detalleAdicional;
        this.nombrePais = nombrePais;
        this.nombreDepartamento = nombreDepartamento;
        this.nombreCiudad = nombreCiudad;
        this.nombreCorregimiento = nombreCorregimiento;
        this.nombreVia = nombreVia;
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

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public String getNombreCiudad() {
        return nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }

    public String getNombreCorregimiento() {
        return nombreCorregimiento;
    }

    public void setNombreCorregimiento(String nombreCorregimiento) {
        this.nombreCorregimiento = nombreCorregimiento;
    }

    public String getNombreVia() {
        return nombreVia;
    }

    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }
}
