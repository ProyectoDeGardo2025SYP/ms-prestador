package co.edu.uco.burstcar.prestador.infraestructura.entrada.ubicacionprestador.controlador.comando;

import co.edu.uco.burstcar.prestador.aplicacion.casodeuso.ubicacionprestador.comando.CasoDeUsoRegistrarUbicacionPrestador;
import co.edu.uco.burstcar.prestador.aplicacion.casodeuso.ubicacionprestador.comando.dto.UbicacionPrestadorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/prestador/ubicacion")
public class ComandoControladorUbicacionPrestador {

    private final CasoDeUsoRegistrarUbicacionPrestador casoDeUsoRegistrarUbicacionPrestador;

    public ComandoControladorUbicacionPrestador(CasoDeUsoRegistrarUbicacionPrestador casoDeUsoRegistrarUbicacionPrestador) {
        this.casoDeUsoRegistrarUbicacionPrestador = casoDeUsoRegistrarUbicacionPrestador;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/nuevo")
    public UUID registrarUbicaion(@RequestBody UbicacionPrestadorDto dto){
        return this.casoDeUsoRegistrarUbicacionPrestador.ejecutarRegistro(dto);
    }

}
