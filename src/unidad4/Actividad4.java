package unidad4;

import java.util.Scanner;

/*
 * Desarrollar un programa Java que mediante un método leerArray lea los datos de un array unidimensional
 * de tipo double y mediante un método producto calcule el producto de sus elementos pares,
 * debiendo imprimir este resultado en el programa principal.
 */
public class Actividad4 {

    public static void main(String[] args) {
        double[] elementos = leerArray();
        System.out.println(String.format("El producto de los valores pares es %.2f", producto(elementos)));
    }

    private static double[] leerArray() {
        Scanner terminal = new Scanner(System.in);
        System.out.print("> Ingrese la cantidad de elementos: ");
        double[] elementos = new double[terminal.nextInt()];
        System.out.println(String.format(
                "\n------------ Cargar %d elementos ------------",
                elementos.length));
        for (int i = 0; i < elementos.length; i++) {
            System.out.print("> Ingrese un valor entero: ");
            elementos[i] = terminal.nextDouble();
        }
        terminal.close();

        return elementos;
    }

    private static double producto(double[] elementos) {
        double producto = 1;
        for (double elemento : elementos) {
            if (elemento % 2 == 0) {
                producto *= elemento;
            }
        }

        return producto;
    }

}
