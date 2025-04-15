package co.edu.uco.burstcar.prestador.infraestructura.entrada.prestador.comando;

import co.edu.uco.burstcar.prestador.aplicacion.casodeuso.DtoResponse;
import co.edu.uco.burstcar.prestador.aplicacion.casodeuso.prestador.comando.CasoDeUsoLoginPrestador;
import co.edu.uco.burstcar.prestador.aplicacion.casodeuso.prestador.comando.CasoDeUsoRegistrarPrestador;
import co.edu.uco.burstcar.prestador.aplicacion.casodeuso.prestador.comando.dto.LoginDto;
import co.edu.uco.burstcar.prestador.aplicacion.casodeuso.prestador.comando.dto.PrestadorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prestador")
public class ComandoControladorPrestador {

    private final CasoDeUsoRegistrarPrestador casoDeUsoRegistrarPrestador;
    private final CasoDeUsoLoginPrestador casoDeUsoLoginPrestador;

    public ComandoControladorPrestador(CasoDeUsoRegistrarPrestador casoDeUsoRegistrarPrestador, CasoDeUsoLoginPrestador casoDeUsoLoginPrestador) {
        this.casoDeUsoRegistrarPrestador = casoDeUsoRegistrarPrestador;
        this.casoDeUsoLoginPrestador = casoDeUsoLoginPrestador;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/nuevo")
    public void registrarPrestador(@RequestBody PrestadorDto dto){
        this.casoDeUsoRegistrarPrestador.ejecutarRegistro(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/sesion")
    public DtoResponse<String> iniciarSesion(@RequestBody LoginDto dto){
        return this.casoDeUsoLoginPrestador.ejecutar(dto);
    }


}
