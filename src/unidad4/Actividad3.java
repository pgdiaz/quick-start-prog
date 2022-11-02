package unidad4;

import java.util.Scanner;

/*
 * Desarrolle un programa Java que permita la lectura y visualización de un array de dos dimensiones
 * (matriz o tabla ) mediante los métodos leer( ) y visualizar( ).
 */
public class Actividad3 {

    public static void main(String[] args) {
        visualizar("Tabla de enteros", leer());
    }

    private static int[][] leer() {
        Scanner terminal = new Scanner(System.in);
        System.out.print("> Ingrese la cantidad de filas: ");
        int filas = terminal.nextInt();
        System.out.print("> Ingrese la cantidad de columnas: ");
        int columnas = terminal.nextInt();
        int[][] tabla = new int[filas][columnas];
        System.out.println("\n------------ Cargar tabla ------------");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("> Ingrese un valor entero: ");
                tabla[i][j] = terminal.nextInt();
            }
        }
        terminal.close();

        return tabla;
    }

    private static void visualizar(String titulo, int[][] tabla) {
        System.out.println(
                String.format("\n------------------- %s -------------------", titulo));
        for (int[] fila : tabla) {
            for (int elemento : fila) {
                System.out.print(String.format("    %d", elemento));
            }
            System.out.println();
        }
    }

}
