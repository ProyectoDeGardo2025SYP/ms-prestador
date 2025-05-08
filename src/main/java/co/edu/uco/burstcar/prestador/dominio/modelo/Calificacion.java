package co.edu.uco.burstcar.prestador.dominio.modelo;

import co.edu.uco.burstcar.prestador.dominio.validador.ValidadorDeAtibutos;

import java.util.UUID;

import lombok.NoArgsConstructor;


@NoArgsConstructor
public class Calificacion extends EntidadIdentificador{

    private Double valor;
    private String comentario;

    private Calificacion(Double valor, String comentario) {
        this.valor = valor;
        this.comentario = comentario;
    }

    public static Calificacion nuevaCalificaion(Double valor, String comentario) {
        ValidadorDeAtibutos.validarObjetoNoNulo(valor, "Valor de la calificación");
        ValidadorDeAtibutos.validarAtributosTexto(comentario, "comentario", 100);
        return new Calificacion(valor, comentario);
    }

    private Calificacion(UUID identificador, Double valor, String comentario) {
        super(identificador);
        this.valor = valor;
        this.comentario = comentario;
    }

    public static Calificacion nuevaCalificaionConIdentificador(UUID id, Double valor, String comentario) {
        ValidadorDeAtibutos.validarObjetoNoNulo(valor, "Valor de la calificación");
        ValidadorDeAtibutos.validarAtributosTexto(comentario, "comentario", 100);
        return new Calificacion(id, valor, comentario);
    }

    public Double getValor() {
        return valor;
    }
    public String getComentario() {
        return comentario;
    }
}
