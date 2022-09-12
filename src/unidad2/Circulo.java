package unidad2;

import java.util.Scanner;

import commons.Impresora;

/*
 * Desarrollar un programa Java que permita el ingreso del radio de un círculo desde el teclado,
 * y determine e imprima el perímetro y la superficie del mismo.
 */
public class Circulo {

    public static void main(String[] args) {
        int radio = obtenerRadio();
        Impresora.imprimir("El périmetro del circulo es %.2f", calcularPerimetro(radio));
        Impresora.imprimir("La superficie del circulo es %.2f", calcularSuperficie(radio));
    }

    private static int obtenerRadio() {
        System.out.println("Ingrese el valor del radio del circulo: ");
        Scanner scanner = new Scanner(System.in);
        int radio = scanner.nextInt();
        scanner.close();

        return radio;
    }

    private static double calcularPerimetro(int radio) {
        return 2 * Math.PI * radio;
    }

    private static double calcularSuperficie(int radio) {
        return Math.PI * radio * radio;
    }

}
