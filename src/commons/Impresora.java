package commons;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Impresora {

    private static final String formatoDefault = "dd/MM/yyyy hh:mm";

    private Impresora() {
    }

    public static void imprimir(String texto) {
        System.out.println(texto);
    }

    public static void imprimir(LocalDateTime fechaHora) {
        System.out.println(DateTimeFormatter.ofPattern(formatoDefault).format(fechaHora));
    }

    public static void imprimir(LocalDateTime fechaHora, String formato) {
        System.out.println(DateTimeFormatter.ofPattern(formato).format(fechaHora));
    }

    public static void imprimir(String formato, Object... parametros) {
        System.out.println(String.format(formato, parametros));
    }

}
