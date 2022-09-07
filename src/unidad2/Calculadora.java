package unidad2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Clase 06/09/2022: Try-Catch-Fynally
 */
public class Calculadora {

    public static void main(String[] args) {
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        boolean error = false;
        try {
            System.out.print("Ingrese el Número: ");
            int num = Integer.parseInt(entrada.readLine());
            System.out.println("El cubo de " + num + " es " + cubo(num));
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
            error = true;
        } finally {
            if (!error) {
                System.out.println("\nPrograma Concluído Exitosamente");
            } else {
                System.out.println("\nPrograma Concluído con error");
            }
        }
    }

    private static double cubo(double valor) {
        return Math.pow(valor, 3);
    }

}
