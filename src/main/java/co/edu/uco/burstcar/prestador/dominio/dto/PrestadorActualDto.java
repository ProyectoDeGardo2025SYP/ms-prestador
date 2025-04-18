package co.edu.uco.burstcar.prestador.dominio.dto;



public class PrestadorActualDto {
    private String usuario;

    private String rol;

    private PrestadorActualDto(String usuario, String rol) {
        this.usuario = usuario;
        this.rol = rol;
    }

    public PrestadorActualDto() {
    }

    public static PrestadorActualDto prestadorActual(String usuario, String rol) {
        return new PrestadorActualDto(usuario, rol);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
