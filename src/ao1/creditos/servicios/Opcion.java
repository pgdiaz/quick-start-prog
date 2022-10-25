package ao1.creditos.servicios;

import java.util.stream.Stream;

public enum Opcion {

    BALANCE(1), SIMULACION(2), SOLICITUD(3), INFORME(4), FINALIZAR(0);

    private int codigo;

    private Opcion(int codigo) {
        this.codigo = codigo;
    }

    public static Opcion of(int codigo) {
        return Stream.of(values())
                .filter(opcion -> opcion.codigo == codigo)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("La opción es inválida."));
    }

}
