package commons;

public class Impresora {

    public static void imprimir(String texto) {
        System.out.println(texto);
    }

    public static void imprimir(String formato, Object... parametros) {
        System.out.println(String.format(formato, parametros));
    }

}
