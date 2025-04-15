package co.edu.uco.burstcar.prestador.aplicacion.mapeador;

public interface MapeadorAplicacion<A, D> {
    D aDominio(A dto);
}
