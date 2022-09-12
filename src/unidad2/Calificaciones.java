package unidad2;

import java.io.IOException;
import java.util.Scanner;

import commons.Impresora;
import commons.ParametroInvalidoExcepcion;

/*
 * Desarrollar un programa que permita el ingreso de la calificación de un
 * alumno en una evaluación y muestre el concepto de la misma.
 */
public class Calificaciones {

    enum Calificacion {
        A, B, C, D, E, F;
    }

    public static void main(String[] args) throws IOException {
        try {
            Calificacion calificacion = obtenerCalificacion();
            String concepto = obtenerConcepto(calificacion);
            Impresora.imprimir("Asigno la siguiente calificación: %s", concepto);
        } catch (IllegalArgumentException error) {
            Impresora.imprimir("La calificación ingresada es inválida");
        } catch (ParametroInvalidoExcepcion error) {
            Impresora.imprimir("Se ha producido el siguiente error: %s", error.getMessage());
        }
    }

    private static Calificacion obtenerCalificacion() {
        System.out.print("Introduzca la calificación del alumno: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        return Calificacion.valueOf(input);
    }

    private static String obtenerConcepto(Calificacion calificacion) {
        switch (calificacion) {
            case A:
                return "Excelente";
            case B:
                return "Notable";
            case C:
                return "Aprobado";
            case D:
            case E:
                return "Suspendido";
            default:
                throw new ParametroInvalidoExcepcion("No existe un concepto asociado a la calificación ingresada");
        }
    }

}
