package unidad4;

import java.util.Scanner;

public class Maximos {

    public static void main(String[] args) {
        double[] elementos;
        Scanner terminal = new Scanner(System.in);
        System.out.print("\n> Ingrese la cantidad de elementos a cargar: ");
        elementos = new double[terminal.nextInt()];
        cargar(terminal, elementos);
        terminal.close();
        double promedio = calcularPromedio(elementos);
        System.out.println(String.format(
                "\nLa cantidad de elementos mayores al promedio %.2f es %d",
                promedio,
                contarMaximos(elementos, promedio)));
    }

    private static void cargar(Scanner terminal, double[] elementos) {
        System.out.println("\n------------ Cargar elementos ------------");
        for (int i = 0; i < elementos.length; i++) {
            System.out.print("Ingrese un valor real: ");
            elementos[i] = terminal.nextDouble();
        }
    }

    private static double calcularPromedio(double[] elementos) {
        double promedio = 0;
        for (double elemento : elementos) {
            promedio += elemento;
        }

        return promedio / elementos.length;
    }

    private static int contarMaximos(double[] elementos, double limite) {
        int contador = 0;
        for (double elemento : elementos) {
            if (elemento > limite) {
                contador++;
            }
        }

        return contador;
    }

}
