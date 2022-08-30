package unidad1;

/**
 * Desarrollar un programa Java con un método main(), que convoque a un método
 * para sumar dos números
 */
public class Sumador {

    public static void main(String[] args) throws Exception {
        int a = 10;
        int b = 25;
        System.out.println(String.format("La suma de %d más %d es %d", a, b, sumar(a, b)));
    }

    private static int sumar(int a, int b) {
        return a + b;
    }

}
