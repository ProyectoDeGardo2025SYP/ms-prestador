package co.edu.uco.burstcar.prestador.dominio.puerto;

import co.edu.uco.burstcar.prestador.dominio.modelo.DelimitacionPrestador;

import java.util.UUID;

public interface RepositorioDelimitacionPrestador {

    DelimitacionPrestador asociarDelimitacionUbicacion(String nombrePais, String nombreDepartamento,
                                                       String nombreCiudad, String nombreCorregimiento);
}
