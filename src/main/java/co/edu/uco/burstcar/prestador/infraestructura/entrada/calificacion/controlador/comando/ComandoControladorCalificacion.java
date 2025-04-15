package co.edu.uco.burstcar.prestador.infraestructura.entrada.calificacion.controlador.comando;

import co.edu.uco.burstcar.prestador.aplicacion.casodeuso.calificacion.comando.CasoDeUsoRegistrarCalificacion;
import co.edu.uco.burstcar.prestador.aplicacion.casodeuso.calificacion.comando.dto.CalificacionDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prestador")
public class ComandoControladorCalificacion {

    private final CasoDeUsoRegistrarCalificacion casoDeUsoRegistrarCalificacion;

    public ComandoControladorCalificacion(CasoDeUsoRegistrarCalificacion casoDeUsoRegistrarCalificacion) {
        this.casoDeUsoRegistrarCalificacion = casoDeUsoRegistrarCalificacion;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}/calificacion")
    public void registrarCalificacion(@RequestBody CalificacionDto dto, @PathVariable String id){
        this.casoDeUsoRegistrarCalificacion.ejecutarRegistro(dto, id);
    }

}
