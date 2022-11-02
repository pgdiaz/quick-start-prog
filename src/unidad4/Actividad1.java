package unidad4;

import java.util.Scanner;

/*
 * Desarrollar un programa Java que lea 10 números enteros, los almacene en un arreglo,
 * y a continuación visualice la suma de los mismos.
 */
public class Actividad1 {

    public static void main(String[] args) {
        int cantidad = 10;
        int[] arreglo = new int[cantidad];
        cargar(arreglo);
        int suma = sumar(arreglo);
        System.out.println(String.format("La suma de los elementos es %d", suma));
    }

    private static void cargar(int[] elementos) {
        Scanner terminal = new Scanner(System.in);
        String titulo = String.format(
                "\n------------ Cargar %d elementos ------------",
                elementos.length);
        System.out.println(titulo);
        for (int i = 0; i < elementos.length; i++) {
            System.out.print("Ingrese un valor entero: ");
            elementos[i] = terminal.nextInt();
        }
        terminal.close();
    }

    private static int sumar(int[] elementos) {
        int suma = 0;
        for (int elemento : elementos) {
            suma += elemento;
        }

        return suma;
    }

}
