package unidad4;

import java.util.Scanner;

public class Inverso {

    public static void main(String[] args) {
        int[] elementos;
        Scanner terminal = new Scanner(System.in);
        System.out.print("\n> Ingrese la cantidad de elementos a cargar: ");
        elementos = new int[terminal.nextInt()];
        cargar(terminal, elementos);
        terminal.close();
        int[] invertido = invertir(elementos);
        mostrar("Arreglo invertido", invertido);
        double promedio = calcularPromedio(elementos);
        mostrar(String.format("Elementos mayores que %.2f", promedio), elementos, promedio);
    }

    private static void cargar(Scanner terminal, int[] elementos) {
        System.out.println("\n------------ Cargar elementos ------------");
        for (int i = 0; i < elementos.length; i++) {
            System.out.print("Ingrese un valor entero: ");
            elementos[i] = terminal.nextInt();
        }
    }

    private static int[] invertir(int[] elementos) {
        int cantidad = elementos.length;
        int[] invertidos = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            invertidos[i] = elementos[cantidad - i - 1];
        }

        return invertidos;
    }

    private static void mostrar(String titulo, int[] elementos) {
        System.out.println(String.format("\n------------ %s ------------", titulo));
        for (int elemento : elementos) {
            System.out.println(elemento);
        }
    }

    private static void mostrar(String titulo, int[] elementos, double limite) {
        System.out.println(String.format("\n------------ %s ------------", titulo));
        for (int elemento : elementos) {
            if (elemento > limite) {
                System.out.println(elemento);
            }
        }
    }

    private static double calcularPromedio(int[] elementos) {
        double promedio = 0;
        for (int elemento : elementos) {
            promedio += elemento;
        }

        return promedio / elementos.length;
    }

}
