package ao2.punto1;

import java.util.Scanner;

public class Arreglos {

    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        try {
            System.out.print("> Ingrese la cantidad de elementos: ");
            int cantidad = terminal.nextInt();
            int[] vectorA = cargar(terminal, cantidad);
            int[] vectorB = cargar(terminal, cantidad);
            int[] vectorC = sumar(vectorA, vectorB);
            double promedio = promedio(vectorC);
            System.out.println(String.format("Promedio del vector C: %.2f", promedio));
            System.out.println("Elementos del vector A mayores al promedio: ");
            mayores(vectorA, promedio);
        } catch (Exception e) {
            System.out.println("\nHa ocurrido un error: " + e.getMessage());
        } finally {
            terminal.close();
        }
    }

    private static int[] cargar(Scanner terminal, int cantidad) {
        int[] elementos = new int[cantidad];
        String titulo = String.format(
                "\n------------ Cargar %d elementos ------------",
                elementos.length);
        System.out.println(titulo);
        for (int i = 0; i < elementos.length; i++) {
            System.out.print("Ingrese un valor entero: ");
            elementos[i] = terminal.nextInt();
        }

        return elementos;
    }

    private static int[] sumar(int[] a, int[] b) {
        int[] suma = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            suma[i] = a[i] + b[i];
        }

        return suma;
    }

    private static double promedio(int[] arreglo) {
        double suma = 0;
        for (int i : arreglo) {
            suma += i;
        }

        return suma / arreglo.length;
    }

    private static void mayores(int[] arreglo, double promedio) {
        for (int i : arreglo) {
            if (i > promedio) {
                System.out.println(i);
            }
        }
    }

}
