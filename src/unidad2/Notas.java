package unidad2;

import java.util.Scanner;

import commons.Impresora;

public class Notas {

    public static void main(String[] args) {
        Impresora.imprimir("Para finalizar la ejecución ingrese un valor negativo");
        Impresora.imprimir("Ingrese un número entero en el rango [0, 10]: ");
        Scanner scanner = new Scanner(System.in);
        int nota = scanner.nextInt();
        while (nota >= 0) {
            if (nota <= 10) {
                Impresora.imprimir(obtenerDetalle(nota));
            } else {
                Impresora.imprimir("La nota no se encuentra en el rango [0, 10]");
            }
            Impresora.imprimir("Ingrese un número entero en el rango [0, 10]: ");
            nota = scanner.nextInt();
        }
        scanner.close();
        Impresora.imprimir("Se finalizó la ejecución");
    }

    private static String obtenerDetalle(int nota) {
        if (nota <= 3) {
            return "Insuficiente";
        } else if (nota <= 6) {
            return "Suficiente";
        } else if (nota <= 8) {
            return "Bien";
        } else {
            return "Muy bien";
        }
    }

}
