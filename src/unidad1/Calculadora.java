package unidad1;

/**
 * Desarrollar un programa en Java, que desde el método main( ) invoque a un
 * método que permita calcular el cubo de un número.
 */
public class Calculadora {

    public static void main(String[] args) throws Exception {
        double valor = 8;
        System.out.println(String.format("El cubo de %.2f es %.2f", valor, calcularCubo(valor)));
    }

    private static double calcularCubo(double valor) {
        return Math.pow(valor, 3);
    }

}
