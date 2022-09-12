package unidad2;

import java.util.Scanner;

import commons.Impresora;

public class Potencias {

    public static void main(String[] args) {
        Impresora.imprimir("Para finalizar la ejecución ingrese un valor negativo");
        Impresora.imprimir("Ingrese un número: ");
        Scanner scanner = new Scanner(System.in);
        double numero = scanner.nextDouble();
        while (numero >= 0) {
            if (numero > 20) {
                Impresora.imprimir("Cuadrado: %.2f", Math.pow(numero, 2));
            } else {
                Impresora.imprimir("Raíz cuadrada: %.2f", Math.sqrt(numero));
            }
            Impresora.imprimir("Ingrese un número: ");
            numero = scanner.nextDouble();
        }
        scanner.close();
    }

}
