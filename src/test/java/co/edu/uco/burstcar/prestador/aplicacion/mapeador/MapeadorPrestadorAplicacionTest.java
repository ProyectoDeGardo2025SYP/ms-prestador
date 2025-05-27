package co.edu.uco.burstcar.prestador.aplicacion.mapeador;

import co.edu.uco.burstcar.prestador.aplicacion.casodeuso.prestador.comando.dto.PrestadorDto;
import co.edu.uco.burstcar.prestador.aplicacion.mapeador.prestador.impl.MapeadorPrestadorAplicacion;
import co.edu.uco.burstcar.prestador.dominio.modelo.IdentificacionPrestador;
import co.edu.uco.burstcar.prestador.dominio.modelo.Prestador;
import co.edu.uco.burstcar.prestador.dominio.modelo.UbicacionPrestador;
import co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioIdentificacionPrestador;
import co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioUbicacionPrestador;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MapeadorPrestadorAplicacionTest {


    @Mock
    private RepositorioUbicacionPrestador repositorioUbicacionPrestador;
    @Mock
    private RepositorioIdentificacionPrestador repositorioIdentificacionPrestador;
    @Mock
    private UbicacionPrestador ubicacionPrestador;
    @Mock
    private IdentificacionPrestador identificacionPrestador;


    @InjectMocks
    private MapeadorPrestadorAplicacion mapeador;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void mapearCorrectamentePrestadorDtoADominio() {
        PrestadorDto dto = new PrestadorDto();
        dto.setNumeroIdentificacion("123");
        dto.setNombre("Juan Pérez");
        dto.setUsuario("juan123");
        dto.setContrasena("secreta");
        dto.setNumeroTelefonico(1234567890L);
        dto.setCategoriaIdentificador("CC");
        when(repositorioUbicacionPrestador.consultarUbicacionPorLatitudYLongitud(12.23456789, 12.23456789))
                .thenReturn(ubicacionPrestador);
        when(repositorioIdentificacionPrestador.asociarTipoIdentificacionPrestador("CC"))
                .thenReturn(identificacionPrestador);

        Prestador dominio = mapeador.aDominio(dto);

        Assertions.assertNotNull(dominio);
        Assertions.assertEquals("123", dominio.getNumeroIdentificacion());
        Assertions.assertEquals("Juan Pérez", dominio.getNombre());
        Assertions.assertEquals("juan123", dominio.getUsuario());
        Assertions.assertEquals("secreta", dominio.getContrasena());
        Assertions.assertEquals(1234567890L, dominio.getNumeroTelefonico());
        Assertions.assertEquals(identificacionPrestador, dominio.getIdentificacionPrestador());
        Assertions.assertEquals(ubicacionPrestador, dominio.getUbicacion());
        verify(repositorioUbicacionPrestador, Mockito.times(1)).consultarUbicacionPorLatitudYLongitud(12.23456789, 12.23456789);
        verify(repositorioIdentificacionPrestador, Mockito.times(1)).asociarTipoIdentificacionPrestador("CC");
    }

    @Test
    void debeRetornarExcepecionPrestadorConIdentificacionEsNull() {
        PrestadorDto dto = new PrestadorDto();
        dto.setNumeroIdentificacion("123");
        dto.setNombre("Juan Pérez");
        dto.setUsuario("juan123");
        dto.setContrasena("secreta");
        dto.setNumeroTelefonico(1234567890L);
        dto.setCategoriaIdentificador("CC");
        when(repositorioIdentificacionPrestador.asociarTipoIdentificacionPrestador("otra"))
                .thenThrow(new IllegalArgumentException("El atributo Identificación del prestador no puede estar nulo"));

        Assertions.assertThrows(IllegalArgumentException.class,  () -> mapeador.aDominio(dto));
    }

    @Test
    void debeRetornarExcepecionPrestadorConUbicacionEsNull() {
        PrestadorDto dto = new PrestadorDto();
        dto.setNumeroIdentificacion("123");
        dto.setNombre("Juan Pérez");
        dto.setUsuario("juan123");
        dto.setContrasena("secreta");
        dto.setNumeroTelefonico(1234567890L);
        dto.setCategoriaIdentificador("CC");
        when(repositorioUbicacionPrestador.consultarUbicacionPorLatitudYLongitud(12.23456789, 12.23456789))
                .thenReturn(ubicacionPrestador);
        when(repositorioUbicacionPrestador.consultarUbicacionPorLatitudYLongitud(null, null))
                .thenThrow(new IllegalArgumentException("El atributo latitud del prestador no puede estar nulo"));

        Assertions.assertThrows(IllegalArgumentException.class,  () -> mapeador.aDominio(dto));
    }


}
