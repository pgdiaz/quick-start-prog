package unidad2;

import java.util.Scanner;

import commons.Impresora;

public class Temperaturas {

    public static void main(String[] args) {
        Impresora.imprimir("¿Cual es el total de temperaturas que desea registrar?");
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        double mayorTemperatura = 0;
        for (int i = 0; i < total; i++) {
            Impresora.imprimir("Ingrese una temperatura: ");
            double temperatura = scanner.nextDouble();
            if (temperatura > mayorTemperatura) {
                mayorTemperatura = temperatura;
            }
        }
        scanner.close();
        Impresora.imprimir("La mayor temperatura registrada es %.2f", mayorTemperatura);
    }

}
