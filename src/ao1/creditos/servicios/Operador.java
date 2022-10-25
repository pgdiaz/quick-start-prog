package ao1.creditos.servicios;

import java.util.Scanner;

public class Operador {

    public static Opcion getOpcion(Scanner terminal) {
        boolean error = true;
        Opcion opcion = null;
        do {
            try {
                mostrarMenuOpciones();
                opcion = Opcion.of(terminal.nextInt());
                error = false;
            } catch (Exception e) {
                System.out.println("Ingresó una opción inválida. Vuelva a intentarlo!");
            }
        } while (error);

        return opcion;
    }

    public static Operacion getOperacion(Opcion opcion) {
        switch (opcion) {
            case BALANCE:
                return new OperacionBalance();
            case SIMULACION:
                return new OperacionSimulacion();
            case SOLICITUD:
                return new OperacionSolicitud();
            case INFORME:
                return new OperacionInformeCrediticio();
            default:
                throw new IllegalArgumentException("La opción no tiene una operación definida.");
        }
    }

    private static void mostrarMenuOpciones() {
        System.out.println("\n------------------------------");
        System.out.println("|       Menu de Opciones       |");
        System.out.println("------------------------------");
        System.out.println("    1) Consultar balance de su linea de crédito");
        System.out.println("    2) Simular un crédito");
        System.out.println("    3) Solicitar un crédito");
        System.out.println("    4) Generar informe crediticio");
        System.out.println("    0) Finalizar\n");
        System.out.print("Opción: ");
    }

}
