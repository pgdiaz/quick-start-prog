package ao1.viaje;

import java.util.Scanner;

public class Cotizador {

    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        System.out.println("Ingrese 0 (cero) para finalizar");
        int cantidadAlumnos = 0;
        Cotizacion cotizacion = new Cotizacion();
        do {
            System.out.print("\nIngrese la cantidad de alumnos que viajarán: ");
            cantidadAlumnos = terminal.nextInt();
            if (cantidadAlumnos > 0) {
                cotizacion.setCantidadPasajeros(cantidadAlumnos);
                imprimirCotizacion(cotizacion);
            } else {
                System.out.println("Adios!");
            }
        } while (cantidadAlumnos > 0);
        terminal.close();
    }

    private static void imprimirCotizacion(Cotizacion cotizacion) {
        System.out.println("\n---------------------------------");
        System.out.println("|            Cotización            |");
        System.out.println("----------------------------------");
        System.out.println(String.format("El costo total del viaje es %.2f", cotizacion.getCostoTotal()));
        System.out.println(String.format("Cada alumno deberá pagar %.2f", cotizacion.getCostoPorPasajero()));
    }

}
