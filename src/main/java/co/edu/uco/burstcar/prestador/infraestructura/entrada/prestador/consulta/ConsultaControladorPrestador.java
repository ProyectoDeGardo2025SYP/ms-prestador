package co.edu.uco.burstcar.prestador.infraestructura.entrada.prestador.consulta;

import co.edu.uco.burstcar.prestador.aplicacion.casodeuso.DtoResponse;
import co.edu.uco.burstcar.prestador.aplicacion.casodeuso.prestador.comando.dto.LoginDto;
import co.edu.uco.burstcar.prestador.aplicacion.casodeuso.prestador.comando.dto.PrestadorDto;
import co.edu.uco.burstcar.prestador.aplicacion.casodeuso.prestador.consulta.CasoDeUsoConsultarPrestador;
import co.edu.uco.burstcar.prestador.dominio.dto.PrestadorConsulta;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prestador")
public class ConsultaControladorPrestador {

    private final CasoDeUsoConsultarPrestador casoDeUsoConsultarPrestador;

    public ConsultaControladorPrestador(CasoDeUsoConsultarPrestador casoDeUsoConsultarPrestador) {
        this.casoDeUsoConsultarPrestador = casoDeUsoConsultarPrestador;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public PrestadorConsulta registrarPrestador(@PathVariable String id){
        return this.casoDeUsoConsultarPrestador.ejecutarConsulta(id);
    }
}
