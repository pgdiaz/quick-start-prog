package unidad5;

import java.util.Arrays;
import java.util.Scanner;

public class Calculos {

    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        try {
            int cantidad = 0;
            do {
                System.out.print("> Ingrese una cantidad (mayor a 5): ");
                cantidad = terminal.nextInt();
            } while (cantidad < 5);
            int[] arreglo = new int[cantidad];
            for (int i = 0; i < arreglo.length; i++) {
                System.out.print("> Ingrese un entero: ");
                int valor = terminal.nextInt();
                insertar(arreglo, i, valor);
            }
            System.out.println("Los 5 menores son: " + Arrays.toString(obtenerCincoMenores(arreglo)));
            System.out.println(String.format(
                    "Promedio de enteros positivos: %.2f",
                    calcularPromedioDePositivos(arreglo)));
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        } finally {
            terminal.close();
        }
    }

    private static void insertar(int[] arreglo, int tope, int valor) {
        if (tope == 0) {
            arreglo[tope] = valor;
        } else {
            int puntero = tope;
            while (puntero > 0 && valor < arreglo[puntero - 1]) {
                arreglo[puntero] = arreglo[puntero - 1];
                puntero--;
            }
            arreglo[puntero] = valor;
        }
    }

    private static int[] obtenerCincoMenores(int[] arreglo) {
        int[] menores = new int[5];
        for (int i = 0; i < menores.length; i++) {
            menores[i] = arreglo[i];
        }
        return menores;
    }

    private static double calcularPromedioDePositivos(int[] arreglo) {
        int contador = 0;
        double suma = 0;
        for (int valor : arreglo) {
            if (valor > 0) {
                suma += valor;
                contador++;
            }
        }

        return suma / contador;
    }

}
