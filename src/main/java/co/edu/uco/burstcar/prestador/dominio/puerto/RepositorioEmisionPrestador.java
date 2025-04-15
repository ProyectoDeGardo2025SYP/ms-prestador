package co.edu.uco.burstcar.prestador.dominio.puerto;

import co.edu.uco.burstcar.prestador.dominio.dto.PrestadorEmisorDto;

public interface RepositorioEmisionPrestador {
    void emitirInformacionPrestador(PrestadorEmisorDto emisorDto);

}
