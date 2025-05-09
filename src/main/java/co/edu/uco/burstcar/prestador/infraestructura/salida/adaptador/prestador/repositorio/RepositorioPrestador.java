package co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.prestador.repositorio;

import co.edu.uco.burstcar.prestador.dominio.dto.PrestadorActualizacionDto;
import co.edu.uco.burstcar.prestador.dominio.dto.PrestadorConsulta;
import co.edu.uco.burstcar.prestador.dominio.modelo.*;
import co.edu.uco.burstcar.prestador.dominio.util.seguridad.EncriptadorContrasena;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.calificacion.entidad.EntidadCalificacion;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.calificacion.repositorio.jpa.RepositorioCalificacionJpa;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.delimitacionprestador.entidad.EntidadDelimitacionPrestador;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.delimitacionprestador.repositorio.jpa.RepositorioDelimitacionPrestadorJpa;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.identificacionprestador.entidad.EntidadIdentificacionPrestador;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.identificacionprestador.repositorio.jpa.RepositorioIdentificacionPrestadorJpa;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.prestador.entidad.EntidadPrestador;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.prestador.repositorio.jpa.RepositorioPrestadorJpa;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.ubicacionprestador.entidad.EntidadUbicacionPrestador;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.ubicacionprestador.repositorio.jpa.RepositorioUbicacionPrestadorJpa;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.viaprestador.entidad.EntidadViaPrestador;
import co.edu.uco.burstcar.prestador.infraestructura.salida.adaptador.viaprestador.repositorio.jpa.RepositorioViaPrestadorJpa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepositorioPrestador implements co.edu.uco.burstcar.prestador.dominio.puerto.RepositorioPrestador {

    private final RepositorioPrestadorJpa repositorioPrestadorJpa;
    private final RepositorioUbicacionPrestadorJpa repositorioUbicacionPrestadorJpa;
    private final RepositorioIdentificacionPrestadorJpa repositorioIdentificacionPrestadorJpa;
    private  final RepositorioDelimitacionPrestadorJpa repositorioDelimitacionPrestadorJpa;
    private  final RepositorioViaPrestadorJpa repositorioViaPrestadorJpa;
    private final RepositorioCalificacionJpa repositorioCalificacionJpa;

    public RepositorioPrestador(RepositorioPrestadorJpa repositorioPrestadorJpa, RepositorioUbicacionPrestadorJpa repositorioUbicacionPrestadorJpa, RepositorioIdentificacionPrestadorJpa repositorioIdentificacionPrestadorJpa, RepositorioDelimitacionPrestadorJpa repositorioDelimitacionPrestadorJpa, RepositorioViaPrestadorJpa repositorioViaPrestadorJpa, RepositorioCalificacionJpa repositorioCalificacionJpa) {
        this.repositorioPrestadorJpa = repositorioPrestadorJpa;
        this.repositorioUbicacionPrestadorJpa = repositorioUbicacionPrestadorJpa;
        this.repositorioIdentificacionPrestadorJpa = repositorioIdentificacionPrestadorJpa;
        this.repositorioDelimitacionPrestadorJpa = repositorioDelimitacionPrestadorJpa;
        this.repositorioViaPrestadorJpa = repositorioViaPrestadorJpa;
        this.repositorioCalificacionJpa = repositorioCalificacionJpa;
    }

    @Override
    public void registrarInformacionPersonal(Prestador prestador) {
        EntidadUbicacionPrestador entidadUbicacionPrestador =
                this.repositorioUbicacionPrestadorJpa.findById(prestador.getUbicacion().getIdentificador()).orElse(null);

        EntidadIdentificacionPrestador entidadIdentificacionPrestador =
                this.repositorioIdentificacionPrestadorJpa.findByCodigo(
                        prestador.getIdentificacionPrestador().getIdentificacionCategoriaId());

        EntidadPrestador entidadPrestador = new EntidadPrestador(
                prestador.getNumeroIdentificacion(), prestador.getNombre(), prestador.getUsuario(),
                prestador.getContrasena(), prestador.getNumeroTelefonico(), entidadUbicacionPrestador,
                entidadIdentificacionPrestador, new ArrayList<>());
        entidadPrestador.setIdentificador(prestador.getIdentificador());

        this.repositorioPrestadorJpa.save(entidadPrestador);
    }

    @Override
    public Prestador realizarInicioSesion(String usuario, String contrasena) {
        EntidadPrestador entidadPrestador = this.repositorioPrestadorJpa.findByUsuario(usuario);

        if (entidadPrestador == null || !EncriptadorContrasena.validarContrasena(contrasena, entidadPrestador.getContrasena())) {
            throw new IllegalArgumentException("Usuario o contraseña incorrectos.");
        }

        EntidadUbicacionPrestador entidadUbicacionPrestador = this.repositorioUbicacionPrestadorJpa.findById(
                entidadPrestador.getEntidadUbicacionPrestador().getIdentificador()).orElse(null);
        EntidadIdentificacionPrestador entidadIdentificacionPrestador = this.repositorioIdentificacionPrestadorJpa.findByCodigo(
                entidadPrestador.getEntidadIdentificacionPrestador().getIdentificacionCategoriaId());
        List<EntidadCalificacion> calificacionesEntidad = this.repositorioCalificacionJpa.obtenerCalificacionesPorPrestador(entidadPrestador.getIdentificador());

        if (calificacionesEntidad == null) {
            calificacionesEntidad = Collections.emptyList();
        }

        EntidadDelimitacionPrestador entidadDelimitacionPrestador = this.repositorioDelimitacionPrestadorJpa.findDelimitacion(
                entidadPrestador.getEntidadUbicacionPrestador().getEntidadDelimitacionPrestador().getNombrePais(),
                entidadPrestador.getEntidadUbicacionPrestador().getEntidadDelimitacionPrestador().getNombreDepartamento(),
                entidadPrestador.getEntidadUbicacionPrestador().getEntidadDelimitacionPrestador().getNombreCiudad(),
                entidadPrestador.getEntidadUbicacionPrestador().getEntidadDelimitacionPrestador().getNombreCorregimiento());
        EntidadViaPrestador entidadViaPrestador = this.repositorioViaPrestadorJpa.findByNombre(
                entidadPrestador.getEntidadUbicacionPrestador().getEntidadViaPrestador().getNombre());

        UbicacionPrestador ubicacionPrestador = getUbicacionPrestador(entidadDelimitacionPrestador, entidadViaPrestador, entidadUbicacionPrestador);
        IdentificacionPrestador identificacionPrestador = IdentificacionPrestador.nuevaIdentificacionPrestadorConIdentificador(
                entidadIdentificacionPrestador.getIdentificador(),
                entidadIdentificacionPrestador.getNombre(),
                entidadIdentificacionPrestador.getIdentificacionCategoriaId());
        ArrayList<Calificacion> calificaciones = calificacionesEntidad.stream()
                .map(e -> Calificacion.nuevaCalificaionConIdentificador(e.getIdentificador(), e.getValor(), e.getComentario()))
                .collect(Collectors.toCollection(ArrayList::new));

        return Prestador.nuevoPrestadorConIdentificador(
                entidadPrestador.getIdentificador(), entidadPrestador.getNumeroIdentificacion(), entidadPrestador.getNombre(),
                entidadPrestador.getUsuario(), entidadPrestador.getContrasena(), entidadPrestador.getNumeroTelefonico(),
                ubicacionPrestador, identificacionPrestador, calificaciones);
    }

    private static UbicacionPrestador getUbicacionPrestador(EntidadDelimitacionPrestador entidadDelimitacionPrestador, EntidadViaPrestador entidadViaPrestador, EntidadUbicacionPrestador entidadUbicacionPrestador) {
        DelimitacionPrestador delimitacionPrestador = DelimitacionPrestador.nuevaDelimitacionConIdentificador(
                entidadDelimitacionPrestador.getIdentificador(), entidadDelimitacionPrestador.getNombreCorregimiento(),
                entidadDelimitacionPrestador.getNombreCiudad(), entidadDelimitacionPrestador.getIdentificacionCiudad(),
                entidadDelimitacionPrestador.getNombreDepartamento(), entidadDelimitacionPrestador.getIdentificacionDepartamento(),
                entidadDelimitacionPrestador.getIdentificacionPais(), entidadDelimitacionPrestador.getNombrePais());
        ViaPrestador viaPrestador = ViaPrestador.nuevaViaConIdentificador(
                entidadViaPrestador.getIdentificador(), entidadViaPrestador.getNombre());
        return UbicacionPrestador.nuevaUbicacionConIdentificador(
                entidadUbicacionPrestador.getIdentificador(), entidadUbicacionPrestador.getNumeroVia(),
                entidadUbicacionPrestador.getDireccion(), entidadUbicacionPrestador.getLatitud(), entidadUbicacionPrestador.getLongitud(),
                entidadUbicacionPrestador.getDetalleAdicional(), delimitacionPrestador, viaPrestador);
    }

    @Override
    public PrestadorConsulta consultarInformacionPrestador(String numeroIdentificacion) {
        EntidadPrestador entidadPrestador =
                this.repositorioPrestadorJpa.consultarPrestadorPorSuIdentificacion(numeroIdentificacion);
        EntidadUbicacionPrestador entidadUbicacionPrestador = this.repositorioUbicacionPrestadorJpa.findById(
                entidadPrestador.getEntidadUbicacionPrestador().getIdentificador()).orElse(null);
        EntidadDelimitacionPrestador entidadDelimitacionPrestador = this.repositorioDelimitacionPrestadorJpa.findDelimitacion(
                entidadPrestador.getEntidadUbicacionPrestador().getEntidadDelimitacionPrestador().getNombrePais(),
                entidadPrestador.getEntidadUbicacionPrestador().getEntidadDelimitacionPrestador().getNombreDepartamento(),
                entidadPrestador.getEntidadUbicacionPrestador().getEntidadDelimitacionPrestador().getNombreCiudad(),
                entidadPrestador.getEntidadUbicacionPrestador().getEntidadDelimitacionPrestador().getNombreCorregimiento());
        EntidadViaPrestador entidadViaPrestador = this.repositorioViaPrestadorJpa.findByNombre(
                entidadPrestador.getEntidadUbicacionPrestador().getEntidadViaPrestador().getNombre());
        UbicacionPrestador ubicacionPrestador = getUbicacionPrestador(entidadDelimitacionPrestador, entidadViaPrestador, entidadUbicacionPrestador);
        List<EntidadCalificacion> calificacionesEntidad = this.repositorioCalificacionJpa.obtenerCalificacionesPorPrestador(entidadPrestador.getIdentificador());
        ArrayList<Calificacion> calificaciones = calificacionesEntidad.stream()
                .map(e -> Calificacion.nuevaCalificaionConIdentificador(e.getIdentificador(), e.getValor(), e.getComentario()))
                .collect(Collectors.toCollection(ArrayList::new));

        return PrestadorConsulta.consulta(entidadPrestador.getIdentificador(), entidadPrestador.getNumeroIdentificacion(),
                entidadPrestador.getNombre(), entidadPrestador.getNumeroTelefonico(), ubicacionPrestador,entidadPrestador.getEntidadIdentificacionPrestador().getIdentificacionCategoriaId(),
                calificaciones);
    }

    @Override
    public void actaulizarInformacionDelPrestador(PrestadorActualizacionDto dto, String numeroIdentificacion) {
        EntidadPrestador entidadPrestador =
                this.repositorioPrestadorJpa.consultarPrestadorPorSuIdentificacion(numeroIdentificacion);
        if(entidadPrestador != null){
            entidadPrestador.setNombre(dto.getNombre());
            entidadPrestador.setUsuario(dto.getUsuario());
            entidadPrestador.setContrasena(dto.getContrasena());
            entidadPrestador.setNumeroTelefonico(dto.getNumeroTelefonico());
            this.repositorioPrestadorJpa.save(entidadPrestador);
        }

    }

    @Override
    public UbicacionPrestador realizarSeguimientoUbicacion(Prestador prestador) {
        return null;
    }
    @Override
    public boolean validarPrestador(String numeroIdentificacion) {
        return false;
    }
}
