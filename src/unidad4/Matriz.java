package unidad4;

import java.util.Scanner;

public class Matriz {

    public static void main(String[] args) {
        int[][] matriz;
        Scanner terminal = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de filas: ");
        int m = terminal.nextInt();
        System.out.print("Ingrese la cantidad de columnas: ");
        int n = terminal.nextInt();
        matriz = new int[m][n];
        cargar(terminal, matriz);
        terminal.close();
        mostrar(matriz);
        imprimir(matriz);
        int[] sumas = sumarFilas(matriz);
        mostrar("Suma por fila", sumas);
    }

    private static void cargar(Scanner terminal, int[][] matriz) {
        System.out.println("\n------------ Cargar matriz ------------");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(String.format("Introduzca el elemento [%d][%d]: ", i, j));
                matriz[i][j] = terminal.nextInt();
            }
        }
    }

    private static void mostrar(int[][] matriz) {
        System.out.println("\n------------ Mostrar matriz ------------");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.println(String.format("Elemento [%d][%d] de valor %d ", i, j, matriz[i][j]));
            }
        }
    }

    private static void imprimir(int[][] matriz) {
        System.out.println("\n\tMatriz de " + matriz.length + " Filas - " + matriz[0].length + " Columnas");
        System.out.print("\t----------------------------");
        for (int i = 0; i < matriz.length; i++) {
            System.out.println("\n");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("\t" + matriz[i][j]);
            }
        }
        System.out.println("\n");
    }

    private static int[] sumarFilas(int[][] matriz) {
        int[] suma = new int[matriz.length];
        int indice = 0;
        for (int[] fila : matriz) {
            int sumador = 0;
            for (int elemento : fila) {
                sumador += elemento;
            }
            suma[indice] = sumador;
            indice++;
        }

        return suma;
    }

    private static void mostrar(String titulo, int[] elementos) {
        System.out.println(String.format("\n------------ %s ------------", titulo));
        for (int elemento : elementos) {
            System.out.println(elemento);
        }
    }

}
